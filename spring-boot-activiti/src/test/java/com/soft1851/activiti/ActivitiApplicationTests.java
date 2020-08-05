package com.soft1851.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ActivitiApplicationTests {

    @Resource
    private ProcessEngineConfiguration configuration;
    @Resource
    private ProcessEngine engine;

    @Test
    public void contextLoads() {
        configuration.setDatabaseSchemaUpdate("drop-create");
        configuration.buildProcessEngine();
    }

    @Test
    public void test() {
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = engine.getIdentityService();
        // ����û���
        Group empGroup = saveGroup(is, "empGroup", "Ա����");
        Group manageGroup = saveGroup(is, "manageGroup", "������");
        Group dirGroup = saveGroup(is, "dirGroup", "�ܼ���");
        // ����û�
        User empA = saveUser(is, "empa"); // Ա��a
        User empB = saveUser(is, "empb"); // Ա��b
        User managea = saveUser(is, "managea"); // ����a
        User manageb = saveUser(is, "manageb"); // ����b
        User dira = saveUser(is, "dira"); // �ܼ�a
        // �󶨹�ϵ
        saveRel(is, empA, empGroup);
        saveRel(is, empB, empGroup);
        saveRel(is, managea, manageGroup);
        saveRel(is, manageb, manageGroup);
        saveRel(is, dira, dirGroup);
    }

    User saveUser(IdentityService is, String id) {
        User u = is.newUser(id);
        u.setPassword("123456");
        is.saveUser(u);
        return u;
    }

    Group saveGroup(IdentityService is, String id, String name) {
        Group g = is.newGroup(id);
        g.setName(name);
        is.saveGroup(g);
        return g;
    }

    void saveRel(IdentityService is, User u, Group g) {
        is.createMembership(u.getId(), g.getId());
    }


    @Test
    public void test2() {
//	    / ���� �� spring�Զ����������ļ�
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // �洢����
        RepositoryService rs = engine.getRepositoryService();
        Deployment dep = rs.createDeployment().addClasspathResource("classpath:/processes/vacation.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        rs.addCandidateStarterGroup(pd.getId(), "empGroup");
    }

}


### spring security�ļ�ԭ��

      ʹ���ڶ����������url���أ��Դ�������Ȩ�ޡ�

       ���ȣ�Ȩ�޹����벻����½��֤�ģ����Ե�½��֤������AuthenticationProcessingFilterҪ����
       ���о��ǶԷ��ʵ���Դ����ɣ�������Դ����������AbstractSecurityInterceptorҪ����

�������������ʵ����ҪһЩ�����ʵ�֣����Ծ�����AuthenticationManager��accessDecisionManager�������֧�š�

�����ȴ�Ź�һ���������̣��û���½���ᱻAuthenticationProcessingFilter���أ�
����AuthenticationManager��ʵ�֣�����AuthenticationManager�����ProviderManager����ȡ�û���֤��Ϣ����ͬ��Provider���õķ���ͬ����Ϊ��Щ��Ϣ�����������ݿ��ϣ�
��������LDAP�������ϣ�������xml�����ļ��ϵȣ��������֤ͨ����Ὣ�û���Ȩ����Ϣ��װһ��User�ŵ�spring��ȫ�ֻ���SecurityContextHolder�У��Ա����������Դʱʹ�á�
������Դ������Ȩ����������urlʱ����ͨ��AbstractSecurityInterceptor���������أ�
���л����FilterInvocationSecurityMetadataSource�ķ�������ȡ������url�����ȫ��Ȩ�ޣ�
�ڵ�����Ȩ������AccessDecisionManager�������Ȩ��������ͨ��spring��ȫ�ֻ���SecurityContextHolder��ȡ�û���Ȩ����Ϣ��
�����ȡ�����ص�url�ͱ�����url�����ȫ��Ȩ�ޣ�Ȼ���������Ĳ��ԣ��У�һƱ������һƱ�񶨣��������Ӷ����ȣ���
���Ȩ���㹻���򷵻أ�Ȩ�޲����򱨴�����Ȩ�޲���ҳ�档


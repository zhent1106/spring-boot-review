var app = angular.module('vacApp', []);
app.controller('writeCtrl', function ($scope, $http, $window) {
    $scope.days = 1;
    $scope.reason = "�н�������";

    $scope.applyVac = function () {
        $http.post(
            "/startVac",
            {
                "days" : $scope.days,
                "reason" : $scope.reason
            }
        ).then(function (response) {
            if (response.data == true) {
                alert("�����ɹ���");
                $window.location.reload();
            }
        })
    }
});
app.controller('myVacCtrl', function ($scope, $http) {

    $scope.vacList = [];

    $scope.myVac = function () {
        $http.get(
            "/myVac"
        ).then(function (response) {
            $scope.vacList = response.data;
        })
    }
});

app.controller('myVacRecord', function ($scope, $http) {

    $scope.vacList = [];

    $scope.myVacRecord = function () {
        $http.get(
            "/myVacRecord"
        ).then(function (response) {
            $scope.vacRecordList = response.data;
        })
    }
});

app.controller("myAudit", function ($scope, $http, $window) {
    $scope.vacTaskList = [];

    $scope.myAudit = function () {
        $http.get(
            "/myAudit"
        ).then(function (response) {
            $scope.vacTaskList = response.data;
        })
    };

    $scope.passAudit = function (taskId, result) {
        $http.post(
            "/passAudit",
            {
                "id" : taskId,
                "vac" : {
                    "result" : result >= 1 ? "���ͨ��" : "��˾ܾ�"
                }
            }
        ).then(function (response) {
            if (response.data == true) {
                alert("�����ɹ���");
                $window.location.reload();
            } else {
                alert("����ʧ�ܣ�");
            }
        })
    }
});

app.controller('myAuditRecord', function ($scope, $http) {

    $scope.auditVacRecordList = [];

    $scope.myAuditRecord = function () {
        $http.get(
            "/myAuditRecord"
        ).then(function (response) {
            $scope.auditVacRecordList = response.data;
        })
    }
});


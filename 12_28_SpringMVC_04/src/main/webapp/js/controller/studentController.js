app.controller("studentController", function ($scope, studentService, classesService) {

    $scope.pagination = {
        currentPage: 1,	                    //代表当前页
        itemsPerPage: 5,	                    //代表每页的记录数
        totalItems: 100,	                    //代表总记录数
        perPageOptions: [5, 10, 15, 20, 25, 30],  //代表分页的选项列表
        onChange: function () {
            $scope.search();
        }
    }
    //条件查询并分页
    $scope.search = () => {
        studentService.search($scope.pagination.currentPage, $scope.pagination.itemsPerPage, $scope.entity).success(response => {
            $scope.students = response.rows;
            $scope.pagination.totalItems = response.total;
        });
    }
    //查询全部班级
    $scope.findAllClasses = () => {
        classesService.findAllClasses().success(response => {
            $scope.classes = response;
        })
    }
    //添加学生
    $scope.toAdd = () => {
        $scope.stuEntity = {};
        $("#myModal").modal("show");
    }

    //修改学生
    $scope.toUpdate = (stu) => {
        $scope.stuEntity = stu;
        $("#myModal").modal("show");
    }

    //点击保存
    $scope.save = () => {
        let url;
        if ($scope.stuEntity.sid) {
            url = "student/update.do";
        } else {
            url = "student/add.do"
        }
        studentService.save(url, $scope.stuEntity).success(response => {
            if (response.success) {
                $scope.search();
            } else {
                alert(response.message);
            }
        })
    }

    //删除学生
    $scope.toDelete = (sid) => {
        studentService.deleteStu(sid).success(response => {
            if (confirm("确定删除吗？")) {
                if (response.success) {
                    $scope.search();
                } else {
                    alert(response.message);
                }
            }
        })
    }
});
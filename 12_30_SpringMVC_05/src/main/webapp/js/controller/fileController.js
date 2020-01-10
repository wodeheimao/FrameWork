app.controller("fileController", function ($scope, fileService) {

    $scope.findAllFiles =()=>{
        fileService.findAllFiles().success(response=>{
            $scope.files =response;
        })
    }
    $scope.download = (file) => {
        fileService.download(file).success(response=>{

        })
    }
});
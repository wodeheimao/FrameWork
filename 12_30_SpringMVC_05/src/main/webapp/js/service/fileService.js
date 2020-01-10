app.service("fileService",function($http) {
    this.findAllFiles = ()=>{
        return $http.get("file/list.do");
    }

    this.download = (file) => {
        return $http.get("file/download.do?fileName="+file);
    }
})
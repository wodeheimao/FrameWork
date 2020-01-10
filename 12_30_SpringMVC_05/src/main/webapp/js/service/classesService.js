app.service("classesService",function($http) {
    this.findAllClasses = ()=>{
        return $http.get("classes/list.do");
    }
})
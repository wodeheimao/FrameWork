app.service("studentService", function ($http) {
    this.search = (page, pageSize, entity) => {
        return $http.post("student/search.do?page=" + page + "&pageSize=" + pageSize, entity);
    }


    this.save=(url,stuEntity) =>{
        return $http.post(url,stuEntity);
    }

    this.deleteStu = (sid) => {
        return $http.get("student/delete.do?sid="+sid);
    }

    this.deleteAll = (sids) => {
        return $http.get("student/deleteAll.do?sids="+sids);
    }
});
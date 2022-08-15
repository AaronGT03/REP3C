<%--
  Created by IntelliJ IDEA.
  User: Brayan
  Date: 12/08/2022
  Time: 01:51 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Persona</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card text-white bg-dark mt-5">
                <div class="card-header"> Editar Persona</div>
                <div class="card-body">
                    <form action="save-persona" method="get" class="form">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="name">Nombre</label>
                                    <input type="text" id="name" name="name" class="form-control" value="${persona.nombre}" required/>
                                    <div class="invalid-feedback">
                                    </div>
                                    <input type="hidden" name="id" value="${persona.id}"/>
                                </div>
                                <div class="col">
                                    <label for="surname">Surname</label>
                                    <input type="text" id="surname" name="surname" class="form-control" value="${persona.surname}" required/>
                                    <div class="invalid-feedback">

                                    </div>
                                </div>
                                <div class="col">
                                    <label for="curp">Curp</label>
                                    <input type="text" id="curp" name="curp" class="form-control" value="${persona.curp}" required/>
                                    <div class="invalid-feedback">
                                    </div>

                                </div>
                                <div class="col">
                                    <label for="cumple">Nacimiento</label>
                                    <input type="text" id="cumple" name="cumple" class="form-control" value="${persona.cumple}" required/>
                                    <div class="invalid-feedback">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3 text-end" >
                            <button type="submit" class="btn btn-success btn-sm">
                                Actulizar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>

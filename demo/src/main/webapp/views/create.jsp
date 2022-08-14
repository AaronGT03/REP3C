<%--
  Created by IntelliJ IDEA.
  User: netmo
  Date: 05/07/2022
  Time: 10:12 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar persona</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card text-white bg-dark mt-5">
                <div class="card-header">REGISTRAR PERSONA</div>
                <div class="card-body ">

                        <div class="col-12 ">
                            <form class="needs-validation" novalidate action="add-persona" method="get"
                                  enctype="multipart/form-data">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="nombre">Nombre</label>
                                            <input type="text" id="nombre" name="nombre" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="surname">Apellidos</label>
                                            <input type="text "name="surname" id="surname" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="curp">Curp</label>
                                            <input name="curp" id="curp" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="cumple">Cumpleaños</label>
                                            <input type="text" name="cumple" id="cumple"required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="submit" class="btn btn-success btn-sm">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../templates/footer.jsp"/>
</body>
</html>

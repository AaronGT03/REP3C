<%--
  Created by IntelliJ IDEA.
  User: netmo
  Date: 29/06/2022
  Time: 02:28 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Personas</title>
    <jsp:include page="./templates/head.jsp"/>
</head>
<body>

    <div class="table">
        <div class="col-12">
            <c:if test="${param['result']}">
                <p><c:out value="${param['message']}"></c:out></p>
            </c:if>
            <div class="card">


                    <table class="table table-primary table-hover datatable">
                        <thead>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Curp</th>
                        <th>Cumpleaños</th>
                        </thead>
                        <tbody>

                        <c:forEach var="persona" items="${personas}" varStatus="status">
                            <tr>

                                <td>
                                    <c:out value="${status.count}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.nombre}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.surname}"/>
                                </td>
                                <td>
                                    <c:out value="${persona.curp}"/>
                                </td>
                                <td>
                                    <c:out value="${persona.cumple}"/>
                                </td>
                                <td>

                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                <a href="create-persona" class="btn btn-outline-success btn-sm">
                    <i data-feather="plus"></i> Registrar persona
                </a>
                <a href="get-persona?id=${persona.id}" class="btn btn-warning
                                    btn-sm"><i data-feather="edit"></i></a>
                <a href="delete-persona-persona?id=${persona.id}" class="btn btn-danger
                                    btn-danger"><i data-feather="trash-2"></i></a>

                    </button>
            </div>
        </div>
    </div>



<jsp:include page="./templates/footer.jsp"/>
<script>
    $(document).ready(() => {
        $('.datatable').DataTable({
            language: {
                url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-MX.json',
            },
        });
        document.getElementById("loaderDiv").style.display = "none";
    })
    feather.replace();
</script>
</body>
</html>
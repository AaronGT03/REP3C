<%@page pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="get-personas">
            <i data-feather="home"></i> Inicio
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="get-persona">
                        <i data-feather="align-left"></i> Persona
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-abilities">Apellidos</a>
                </li>
            </ul>
        </div>
        <form method="post" action="logout">
            <button type="submit" class="btn btn-outline-danger mt-1">
                <i data-feather="log-out"></i> Cerrar sesión
            </button>
        </form>
    </div>
</nav>

<script>
    feather.replace();
</script>
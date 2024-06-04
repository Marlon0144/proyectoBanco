
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.backproyectoweb.resources.Model.entidades.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Cuentas - Banco SA</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">Banco SA</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Cuentas</h1>
                        
                        <%
                            // Obtener la lista de cuentas bancarias del atributo de solicitud
                            ArrayList<CuentaBancaria> accounts = (ArrayList<CuentaBancaria>) request.getAttribute("cuentas");
                            // Verificar que la lista de cuentas no sea nula
                            if (accounts != null) {
                                // Iterar sobre las cuentas en pares
                                for (int i = 0; i < accounts.size(); i += 2) {
                        %>
                                    <div class="row">
                                        <%
                                            // Iterar sobre los elementos dentro del par actual
                                            for (int j = i; j < i + 2 && j < accounts.size(); j++) {
                                                CuentaBancaria account = accounts.get(j);
                                                int numberAccount = account.getNumberAccount();
                                        %>
                                                <div class="col-lg-6">
                                                    <div class="card mb-4">
                                                        <div class="card-header">
                                                            <i class="fas fa-chart-bar me-1"></i>
                                                            cuenta<%= numberAccount %>
                                                        </div>
                                                        <form action="cuenta">
                                                            <div class="card-body" id="cuenta<%= account.getNumberAccount() %>"></div>
                                                            <input type="hidden" name="numberAccount" value=<%= account.getNumberAccount() %>>
                                                            <input type="hidden" name="saldo" value=<%= account.getSaldo()%>>
                                                            <input type="hidden" name="interes" value=<%= account.getInteres() %>>
                                                            <button type="submit">Entrar</button>
                                                        </form>
                                                    </div>
                                                </div>
                                        <%
                                            }
                                        %>
                                    </div>
                        <%
                                }
                            }
                        %>
                        
                        
                    
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="assets/demo/chart-pie-demo.js"></script>
        
        <script>
            // Obtener el botón "Crear Cuenta" por su id
            var btnCrearCuenta = document.getElementById('btnCrearCuenta');

            // Agregar un evento clic al botón
            btnCrearCuenta.addEventListener('click', function() {

                // Crear un nuevo elemento de tarjeta para representar la nueva cuenta
                var nuevaCuenta = document.createElement('div');
                nuevaCuenta.classList.add('card', 'mb-4');
                nuevaCuenta.innerHTML = `
                    <div class="card-header">
                        <i class="fas fa-chart-bar me-1"></i>
                        Cuenta 10
                    </div>
                    <div class="card-body">
                        Contenido de la cuenta 10
                    </div>
                `;

                // Obtener el contenedor de las cuentas
                var contenedorCuentas = document.getElementById('layoutSidenav_content').querySelector('.container-fluid');

                // Agregar la nueva cuenta al DOM
                contenedorCuentas.insertBefore(nuevaCuenta, contenedorCuentas.lastElementChild);
            });
        </script>
        
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>E-Commerce</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>E-Commerce</h1>
	<p>Encuentra nuestros precios como nunca antes</p>
	<header>
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="buscar.jsp">Buscar por categoría</a></li>
				<li><a href="verproductos.jsp">Ver productos</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div id="content">
			<section class="container mt-5">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="card">
							<h5 class="card-header">Login</h5>
							<div class="card-body">
								<form action="login.jsp" method="post">
									<div class="mb-3">
										<label for="username" class="form-label">Usuario</label> <input
											type="text" class="form-control" id="username"
											name="username" placeholder="Ingresa tu usuario" required>
									</div>
									<div class="mb-3">
										<label for="password" class="form-label">Contraseña</label> <input
											type="password" class="form-control" id="password"
											name="password" placeholder="Ingresa tu contraseña" required>
									</div>
									<div class="d-grid">
										<button type="submit" class="btn btn-primary" onclick="iniciarSesion()">Iniciar
											sesión</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</main>
	<footer>
		<p>Síguenos en nuestras redes sociales:</p>
		<ul>
			<li><a href="https://www.facebook.com/tuusuario" target="_blank">Facebook</a></li>
			<li><a href="https://www.twitter.com/tuusuario" target="_blank">Twitter</a></li>
			<li><a href="https://www.instagram.com/tuusuario"
				target="_blank">Instagram</a></li>
			<li><a href="https://www.linkedin.com/in/tuusuario"
				target="_blank">LinkedIn</a></li>
		</ul>
	</footer>
	<script type="text/javascript">
		function iniciarSesion(){
			let usuario=document.getElementById("username").value;
			let contrasenia=document.getElementById("password").value;
			if(usuario == "francix" && contrasenia =="1234"){
				alert("Bienvenido");
			}else{
				alert("Credenciales incorrectas");
			}
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>

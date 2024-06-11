<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.productos.negocio.*"%>
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
			<section>
				<article>
					<form action="buscar.jsp" method="post">
						<label for="cmbCategoria">Buscar por categoría:</label>
						<%
						Categoria categoria = new Categoria();
						String comboHtml = categoria.mostrarCategoria();
						out.print(comboHtml);
						%>
						<button class="btn btn-primary" type="submit">Buscar</button>
					</form>
					<%
					String idCategoria = request.getParameter("cmbCategoria");
					if (idCategoria != null && !idCategoria.isEmpty()) {
						Producto producto = new Producto();
						int categoriaId = Integer.parseInt(idCategoria);
						String tablaHtml = producto.buscarProductoCategoria(categoriaId);
						out.print(tablaHtml);
						
					}else if (idCategoria==null){
						String tablaHtml = "<label>No existen Datos en la tabla producto</label>";
						out.print(tablaHtml);

					}
					%>
					

				</article>
			</section>
			<aside>
				<h2>Ofertas destacadas</h2>
				<div class="ofertas">
					<div class="oferta">
						
						<h3>Producto 1</h3>
						<p>¡Aprovecha esta oferta especial!</p>
						<span class="precio-oferta">$19.99</span>
						<del class="precio-original">$29.99</del>
						<a href="#" class="btn-comprar">Comprar ahora</a>
					</div>
					<div class="oferta">
						
						<h3>Producto 2</h3>
						<p>No te pierdas esta promoción exclusiva</p>
						<span class="precio-oferta">$14.99</span>
						<del class="precio-original">$24.99</del>
						<a href="#" class="btn-comprar">Comprar ahora</a>
					</div>
				</div>
				<h2>Últimas noticias</h2>
				<ul class="noticias">
					<li><a href="#">Nuevo producto disponible</a></li>
					<li><a href="#">Promoción de primavera</a></li>
					<li><a href="#">Conoce nuestros descuentos</a></li>
				</ul>
			</aside>
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

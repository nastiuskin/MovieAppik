<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Movie Information</title>
</head>
<body>
<h1>Movie Information</h1>
<jsp:useBean id="movie" scope="request" type="Entities.Movie"/>
<c:if test="${not empty movie}">
    <p>Title: ${movie.title}</p>
    <p>Original Language: ${movie.originalLanguage}</p>
    <p>Overview: ${movie.overview}</p>
    <p>Media Type: ${movie.mediaType}</p>
    <p>Genres: ${movie.genres}</p>
    <p>Rating: ${movie.rating}</p>
    <p>Release Date: ${movie.releaseDate}</p>
    <p><a href="${movie.watchUrl}">Watch Now</a></p>
</c:if>
<p>Movie not found.</p>
</body>

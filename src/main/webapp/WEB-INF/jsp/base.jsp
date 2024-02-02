<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "HGame";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link href="<c:url value="../../css/main.css" />" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script defer type="text/javascript" src="../../js/page/index.js"></script>
        <script type="text/javascript" src="../../js/page/search-bar.js"></script>
        <script defer type="text/javascript" src="../../js/page/navbar.js"></script>


    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light fixed-top mask-custom shadow-0" id="navbar">
            <div class="container-fluid">
                <a class="navbar-brand me-2" href="${s:mvcUrl('AppHome#index').build()}">
                    <img src="${contextPath}/css/asset/logo.png" alt="logo" id="logo" style="width:60px; height:60px">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon pe-3"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item px-3" id = "item-navbar">
                            <a class="nav-link custom-link fw-bolder" aria-current="page" id="id_container1" href="${s:mvcUrl('AppPlatform#index').build()}">PLATE-FORMES</a>
                        </li>
                        <li class="nav-item px-3" id = "item-navbar">
                            <a class="nav-link  custom-link fw-bolder" aria-current="page" href="${s:mvcUrl('AppPlatform#index').build()}">JEUX</a>
                        </li>
                        <li class="nav-item px-3" id = "item-navbar">
                            <a class="nav-link  custom-link fw-bolder" aria-current="page" href="${s:mvcUrl('AppPlatform#index').build()}">EDITEURS</a>
                        </li>
                        <li class="nav-item px-3" id = "item-navbar">
                            <a class="nav-link  custom-link fw-bolder" aria-current="page" href="${s:mvcUrl('AppPlatform#index').build()}">ABONNEMENTS</a>
                        </li>
                    </ul>
                    <form class="d-flex py-2 px-2" role="search">
                            <button class="btn btn-outline-success bolder btn-sm rounded-pill" type="submit" id:"btn-navbar">CONNEXION</button>
                    </form>
                </div>
            </div>
        </nav>




<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | Corlate</title>
	
	<!-- core CSS -->
	
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/prettyPhoto.css"/> rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet">
   
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Vollkorn" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
    <link type="text/css" href="<c:url value="/resources/css/principale.css"/>" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<c:url value="/resourcesjs/html5shiv.js"/>" ></script>
    <script src="<c:url value="/resourcesjs/respond.min.js"/>"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<c:url value="/resources/images/ico/favicon.ico"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/resources/images/ico/apple-touch-icon-144-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/resources/images/ico/apple-touch-icon-114-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/resources/images/ico/apple-touch-icon-72-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/images/ico/apple-touch-icon-57-precomposed.png"/>">
</head><!--/head-->

<body class="homepage">

    <header id="header">
        <nav class="navbar navbar-inverse nav1" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="<c:url value="/resources/images/logo.png"/>" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active" style="font-size: 18px; font-family: vollkorn;"><a href="index.html" >Home</a></li>
                        <li style="font-size: 18px; font-family: vollkorn;"><a class="alin" href="about-us.html">About Us</a></li>
                        <li style="font-size: 18px; font-family: vollkorn;"><a class="alin" href="services.html">Services</a></li>
                        <li style="font-size: 18px; font-family: vollkorn;"><a class="alin" href="portfolio.html">Portfolio</a></li>
                        <li class="dropdown" style="font-size: 18px; font-family: vollkorn;">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="blog-item.html">Blog Single</a></li>
                                <li><a href="pricing.html">Pricing</a></li>
                                <li><a href="404.html">404</a></li>
                                <li><a href="shortcodes.html">Shortcodes</a></li>
                            </ul>
                        </li>
                        <li style="font-size: 18px; font-family: vollkorn;"><a href="blog.html">Blog</a></li> 
                        <li style="font-size: 18px; font-family: vollkorn;"><a href="contact-us.html">Contact</a></li>                        
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header><!--/header-->
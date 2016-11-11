<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="fr">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | Corlate</title>
	
	<!-- core CSS -->
    <link href="<c:url value="resources/css/form.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/animate.min.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/prettyPhoto.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/responsive.css"/>" rel="stylesheet">
    <link href="<c:url value="resources/css/main.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Vollkorn" />
    
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

                        <li class="active lis" style="font-size:15 px"><a href="index.html">Home</a></li>
                        <li style="font-size:15 px"><a class="alin" href="about-us.html">About Us</a></li>
                        <li style="font-size:15 px"><a class="alin" href="services.html">Services</a></li>
                        <li style="font-size:15 px"><a class="alin" href="portfolio.html">Portfolio</a></li>
                        <li class="dropdown" style="font-size:15 px">

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="blog-item.html">Blog Single</a></li>
                                <li><a href="pricing.html">Pricing</a></li>
                                <li><a href="404.html">404</a></li>
                                <li><a href="shortcodes.html">Shortcodes</a></li>
                            </ul>
                        </li>

                        <li style="font-size:15 px"><a href="blog.html">Blog</a></li> 
                        <li style="font-size:15 px"><a href="contact-us.html">Contact</a></li>                        


                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header><!--/header-->
<f:form modelAttribute="avocat" action="ajouterAvocat" method="post" enctype="multipart/form-data">
<ul class="form-style-1">
    <li><label>Nom Et Prenom <span class="required">*</span></label><f:input type="text" path="nomAvocat" class="field-divided" placeholder="Nom" />&nbsp;<f:input type="text" path="prenomAvocat" class="field-divided" placeholder="Prenom" /></li>
    <li>
        <label>Email <span class="required">*</span></label>
        <f:input type="email" path="emailAvocat" class="field-long" />
    </li>
     <li>
     <div class="row">
     <div class="col-md-6">
       <label>Mot De Passe  <span class="required">*</span></label>
       <f:input type="password" path="motDePasse" class="field-long" placeholder="Password" /></div>
       <div class="col-md-6">
        <label>Confirmation Du Mot De Passe <span class="required">*</span></label>
       <input type="password" name="field5" class="field-long" placeholder="Confirmation" /></div> 
      </div>
    </li>
    <li>
        <label>Ville</label>
        <f:select path="ville.nomVille"  items="${villes}" itemValue="nomVille" itemLabel="nomVille"  >
        	
        </f:select>
    </li>
    <li>
        <label>Domaine</label>
        <select name="field6" class="field-select">
        	<c:forEach var="domaine" items="${domaines}" >
        		<option> <c:out value="${domaine.nomDomaine}"></c:out></option>
   			</c:forEach>
        </select>
    </li>
    <li>
        <label>Numero et rue du cabinet <span class="required">*</span></label>
        <f:textarea path="adresseAvocat" id="field7" class="field-long field-textarea" placeholder="Exemple: 11,Avenue du 16 Novembre"></f:textarea>
    </li>
    <li>
     <div class="row">
     <div class="col-md-6">
       <label>Numero de telephone(cabinet)  <span class="required">*</span></label>
       <f:input type="tel" path="telCabinet" class="field-long" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" placeholder="0537666418" /></div>
       <div class="col-md-6">
        <label>Telephone portable </label>
		<f:input type="tel" path="telPortableAvocat" class="field-long" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" placeholder="0660666418" />      </div>
    </li>
    <li>
        <label>Vos Langues parlées</label>
        <select name="field11" class="field-select">
        	<c:forEach var="langue" items="${langues}" >
        		<option> <c:out value="${langue.nomLangue}"></c:out></option>
   			</c:forEach>
        </select>
    </li>
      <li>
        <label>Diplome <span class="required">*</span></label>
        <f:input type="text" path="diplome" class="field-long" />
    </li>
    
    <li>
    <label>Votre photo</label>
    <input type="file" name="file" />
    </li>
    <li>
        <label>Description <span class="required">*</span></label>
        <f:textarea path="description" id="field10" class="field-long field-textarea" placeholder="mrihy ghzal"></f:textarea>
    </li>
    
    <li>
        <input type="submit" value="Submit" />
    </li>
</ul>
</f:form>

</body>
</html>
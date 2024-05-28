

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/Components/Header.jsp" %>
 <body id="top">

  <div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>
    

<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->
    

    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
      <div class="container-fluid">
        <div class="row align-items-center">
          <div class="site-logo col-6"><a href="index.html">BricoConnect</a></div>

          <nav class="mx-auto site-navigation">
            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
              <li><a href="Home_Artisan.html" class="nav-link active">Home</a></li>
              
              
              <li><a href="blog.html">Blog</a></li>
              <li><a href="contact.html">Contact</a></li>
              <li class="d-lg-none"><a href="post-job.html"><span class="mr-2">+</span> Post a Job</a></li>
              <li class="d-lg-none"><a href="login.html">Profile</a></li>
            </ul>
          </nav>
          
          <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
            <div class="ml-auto">
              <a href="login.html" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(255, 255, 255, 1);transform: ;msFilter:;"><path d="M12 2a5 5 0 1 0 5 5 5 5 0 0 0-5-5zm0 8a3 3 0 1 1 3-3 3 3 0 0 1-3 3zm9 11v-1a7 7 0 0 0-7-7h-4a7 7 0 0 0-7 7v1h2v-1a5 5 0 0 1 5-5h4a5 5 0 0 1 5 5v1z"></path></svg></span>Profile</a>
            </div>
            <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3"><span class="icon-menu h3 m-0 p-0 mt-2"></span></a>
          </div>

        </div>
      </div>
    </header>


    <!-- HOME -->
    <section class="section-hero overlay inner-page bg-image" style="background-image: url('Assets/images/hero_1.jpg');" id="home-section">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h1 class="text-white font-weight-bold">Profile</h1>
            <div class="custom-breadcrumbs">
              <a href="#">Home</a> <span class="mx-2 slash">/</span>
              <span class="text-white"><strong>Profile</strong></span>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="site-section">
      <div class="container">
       
          
           
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <!-- Profile picture upload button-->
                            <button class="btn btn-primary" type="button">Upload new image</button>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="profile" method="post" >
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                  <!-- Form Group (first name)-->
                                  <div class="col-md-6">
                                      <label class="small mb-1" for="inputFirstName">First name</label>
                                      <input class="form-control" id="inputFirstName" type="text" placeholder="Enter your first name" name="Nom" value="${artisan.getNom()}">
                                  </div>
                                  <!-- Form Group (last name)-->
                                  <div class="col-md-6">
                                      <label class="small mb-1" for="inputLastName">Last name</label>
                                      <input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" name="Prenom" value="${artisan.getPrenom()}">
                                  </div>
                              </div>
                              <!-- Form Group (email address)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                    <input class="form-control" id="inputEmailAddress" type="email" placeholder="Enter your email address" name="Email" value="${artisan.getEmail()}">
                                </div>
                                <!-- Form Row        -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (organization name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputOrgName">CIN</label>
                                        <input class="form-control" id="inputOrgName" type="text" placeholder="Enter your CIN" name="CIN" value="${artisan.getCIN()}">
                                    </div>
                                    <!-- Form Group (location)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Phone Number</label>
                                        <input class="form-control" id="inputLocation" type="text" placeholder="Enter your phone number" name="NumeroDeTelephone" value="${artisan.getNumeroDeTelephone()}"  >
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                  <!-- Form Group (phone number)-->
                                  <div class="col-md-6">
                                    <label class="small mb-1" for="selctpicker">Langues</label>
                                    <select class="selectpicker form-control" id="selctpicker" multiple name="Langue">
                                      <option>Arabe</option>
                                      <option>Anglais</option>
                                      <option>Francais</option>
                                    </select>
                                   
                                  </div>
                                  <!-- Form Group (birthday)-->
                                  <div class="col-md-6">
                                      <label class="small mb-1" for="inputBirthday">Birthday</label>
                                      <input class="form-control" id="inputBirthday" type="text" name="" placeholder="Enter your birthday" value="16/10/2002" >
                                  </div>
                              </div>
                                <!-- Form Group (username)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Adress</label>
                                    <input class="form-control" id="inputUsername" type="text" name="Adresse" placeholder="Enter your username" value="${artisan.getAdresse()}">
                                </div>
                                <!-- Form Row-->
                                <div class="form-group">
               						 <label for="message-text" class="col-form-label">Formation:</label>
                					<input class="form-control" id="message-text" name="Formation" value="${artisan.getNumeroDeTelephone()}"></input>
            					</div>
            					<!-- Form Row-->
                               <div class="form-group">
              					  <label for="message-text" class="col-form-label">Competences:</label>
              					  <input class="form-control" id="message-text" type='text' name="Competences" value="${artisan.getNumeroDeTelephone()}" ></input>
            					</div>
            					<div class="form-group">
              					  <label for="message-text" class="col-form-label">Experiences professionnelles:</label>
              					  <input class="form-control" id="message-text" type='text' name="ExperienceProfessionnelle" value="${artisan.getExperienceProfessionnelle()}" ></input>
            					</div>
                                </div>
                                
                                
                                
                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="submit">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
          
        
    </section>
 <%@include file="/WEB-INF/Components/Footer.jsp" %>
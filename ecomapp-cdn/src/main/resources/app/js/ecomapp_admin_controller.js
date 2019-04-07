// Creating the Admin Angular Controller
adminApp.controller('ecomappAdminCtrl', function ($http, $scope) {

  // method for getting user details
  var getUser = function () {
    $http.get('/user').then(function (response) {
      $scope.user = response.data;
      console.log('Logged User : ', user);
    }).catch(function (err) {
    });
  };
  getUser();

  // method for logout
  $scope.logout = function () {
    $http.post('/logout').then(function (res) {
      $scope.user = null;
    }).catch(function (err) {
    });
  };

  /************************* Initialize Variable **********************/
  $scope.showLoadingOverlay = false;
  $scope.appHomeSetting = {};
  $scope.appHomeSetting.id = "";

  $scope.appHomeSetting.appLogoText = "";
  $scope.appHomeSetting.appLogoTextLink = "";

  $scope.appHomeSetting.appSubHeaderImageFileName = "";
  $scope.appHomeSetting.appSubHeaderImageText1 = "";
  $scope.appHomeSetting.appSubHeaderImageText2 = "";
  $scope.appHomeSetting.appSubHeaderImageButtonText = "";

  $scope.appHomeSetting.contactHeaderText = "";
  $scope.appHomeSetting.contactSectionText = "";

  $scope.appHomeSetting.aboutHeaderText = "";
  //create links
  $scope.appHomeSetting.aboutSectionText1 = "";
  $scope.appHomeSetting.aboutSectionLink1 = "";
  $scope.appHomeSetting.aboutSectionText2 = "";
  $scope.appHomeSetting.aboutSectionLink2 = "";
  $scope.appHomeSetting.aboutSectionText3 = "";
  $scope.appHomeSetting.aboutSectionLink3 = "";
  $scope.appHomeSetting.aboutSectionText4 = "";
  $scope.appHomeSetting.aboutSectionLink4 = "";
  $scope.appHomeSetting.aboutSectionText5 = "";
  $scope.appHomeSetting.aboutSectionLink5 = "";
  $scope.appHomeSetting.aboutSectionText6 = "";
  $scope.appHomeSetting.aboutSectionLink6 = "";
  $scope.appHomeSetting.aboutSectionText7 = "";
  $scope.appHomeSetting.aboutSectionLink7 = "";
  $scope.appHomeSetting.aboutSectionText8 = "";
  $scope.appHomeSetting.aboutSectionLink8 = "";
  $scope.appHomeSetting.aboutSectionText9 = "";
  $scope.appHomeSetting.aboutSectionLink9 = "";

  $scope.appHomeSetting.storeHeaderText = "";
  $scope.appHomeSetting.companyLocation = "";
  $scope.appHomeSetting.companyPhoneNumber = "";
  $scope.appHomeSetting.companyEmailId = "";

  $scope.appHomeSetting.weAcceptHeaderText = "";
  $scope.appHomeSetting.weAccept1 = "";
  $scope.appHomeSetting.weAccept2 = "";

  $scope.appHomeSetting.faceBookLink = "";
  $scope.appHomeSetting.instagramLink = "";
  $scope.appHomeSetting.snapchatLink = "";
  $scope.appHomeSetting.pintrestLink = "";
  $scope.appHomeSetting.twitterLink = "";
  $scope.appHomeSetting.linkedInLink = "";
  $scope.appHomeSetting.youtubeLink = "";

  $scope.appHomeSetting.currentYear = "";
  $scope.appHomeSetting.footerText = "";
  $scope.appHomeSetting.modifiedBy = "";
  $scope.appHomeSetting.modifiedDateFormatted = "";

  /***************************************** Event function Home Page**********************************/
  //API to fetch homepage setting on load
  $scope.getHomePageSettings = function () {
    $http.get("/admin/getHomePageSettings")
    .then(function (response) {
      $scope.appHomeSetting = response.data;
      if ($scope.appHomeSetting.modifiedDate != null
          && $scope.appHomeSetting.modifiedDate != undefined) {
        let dt = new Date($scope.appHomeSetting.modifiedDate.millis);
        $scope.appHomeSetting.modifiedDateFormatted = dt.toLocaleString();
      }
    });
  };
  $scope.getHomePageSettings();//Fetch homepage setting
  $scope.showHomePage = true;//Now Display homepage tab

  //Method invoked on Click of "Save Details" of Application Home Page
  $scope.saveHomePageSetting = function (event) {
    if (!confirm("Are you sure you want to save the data?")) {
      event.preventDefault();
      return;
    }
    var url = "/admin/saveHomePageSettings";
    //copy everything from $scope.appHomeSetting to FormData
    //No need to send modifiedDate
    $scope.appHomeSetting.modifiedDate = "";

    var data = new FormData();
    for (var key in $scope.appHomeSetting) {
      if ($scope.appHomeSetting[key] != undefined || $scope.appHomeSetting[key]
          != null) {//Copy if feild value is not null or undefined
        data.append(key, $scope.appHomeSetting[key]);
      }
    }
    //required for multipart submission using ajax
    var config = {
      transformRequest: angular.identity,
      transformResponse: angular.identity,
      headers: {
        'Content-Type': undefined
      }
    };
    $scope.showLoadingOverlay = true;//Mask the window
    $http.post(url, data, config).then(
        // Success
        function (response) {
          $scope.getHomePageSettings();//Refresh Home Setting Page post update
          alert("Record updated successfully!");
          $scope.showLoadingOverlay = false;//Unmask window
          document.getElementById("appSubHeaderImageFile").value = "";//reset appSubHeaderNewImageFile type
        },
        // Error
        function (response) {
          console.log('Error:');
          alert("Some error occurred!");
          console.log(response);
          $scope.showLoadingOverlay = false;//Unmask window
        });
    event.preventDefault();
  };
});
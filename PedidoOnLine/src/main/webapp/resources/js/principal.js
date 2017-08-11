/**
 * 
 */

$(document).ready(function() {  
  $(window).scroll(function () { 

//    console.log($(window).scrollTop());

    if ($(window).scrollTop() > 300) {
      $('#nav_bar').addClass('navbar-fixed-top');
    }

    if ($(window).scrollTop() < 301) {
      $('#nav_bar').removeClass('navbar-fixed-top');
    }
  });
});
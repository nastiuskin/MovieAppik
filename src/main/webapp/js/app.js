$(document).ready(() => {
  $('#hamburger-menu').click(() => {
  $('#nav-menu').toggleClass('active')
  $('#hamburger-menu').toggleClass('active')

  })


  //SETTINGS OWL CAROUSEL
   
  let navText = ["<i class='bx bx-chevron-left'></i>", "<i class='bx bx-chevron-right'></i>"]


  $('#hero-carousel').owlCarousel({
    items: 1,
    dots: false,
    loop: true,
    nav: true,
    navText: navText,
    autoplay: true,
    autoplayHoverPause: true
  })

  $('#top-movies-slide').owlCarousel({
    items: 6,
    dots: false,
    loop: true,
    autoplay: true,
    autoplayHoverPause: true,
    responsive: {
        500: {
          items: 3
        },

        1280: {
          items: 4
        },

        1600: {
          items: 6
        }
    }
  })

  $('.movies-slide').owlCarousel({
    items: 6,
    dots: false,
    nav: true,
    navText: navText,
    margin: 15,
    responsive: {
        500: {
          items: 3
        },

        1280: {
          items: 4
        },

        1600: {
          items: 6
        }
    }
  })

})

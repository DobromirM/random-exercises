(function($) {
    $(function() {
        $('.jcarousel').jcarousel();

        $('.jcarousel').jcarouselAutoscroll({
          target: '+=1'
        });

        $('.jcarousel').jcarouselAutoscroll({
          interval: 2000
        });

        $('.jcarousel').jcarousel({
          wrap: 'both'
        });

        $('.jcarousel-pagination').jcarouselPagination({
           'item': function(page, carouselItems) {
            return '<a href="#' + page + '"><div class="carouselIcon"><img src="images/carousel_inactive.png" alt="' + page + '"></div>' + '</a>';
          }
        });

        $('.jcarousel-pagination2').jcarouselPagination({
           'item': function(page, carouselItems) {
            return '<a href="#' + page + '"><div class="carouselIcon"><img src="images/carousel2_inactive.png" alt="' + page + '"></div>' + '</a>';
          }
        });

        $('.jcarousel-pagination')
            .on('jcarouselpagination:active', 'a', function() {
                $(this).find("img").attr("src", "images/carousel_active.png");
            })
            .on('jcarouselpagination:inactive', 'a', function() {
                $(this).find("img").attr("src", "images/carousel_inactive.png");
            })
            .jcarouselPagination();


       $('.jcarousel-pagination2')
           .on('jcarouselpagination:active', 'a', function() {
               $(this).find("img").attr("src", "images/carousel2_active.png");
           })
           .on('jcarouselpagination:inactive', 'a', function() {
               $(this).find("img").attr("src", "images/carousel2_inactive.png");
           })
           .jcarouselPagination();

           
    });
})(jQuery);

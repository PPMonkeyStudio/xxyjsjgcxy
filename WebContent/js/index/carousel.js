//carousel_big start
$(document).ready(function() {
    $('.swiper_Myslide li').each(function() {
        var ff = $(this).text();
        var index = $(this).index();
        $('.uldian').append("<li></li>");
    });
});

$(document).ready(function() {
    $('.swiper_Myslide li').width($(window).width());
    time = 2000;
    slide_Time = 500;
    int = self.setInterval("clock()", time);
    ulLen = $('.swiper_Myslide li').length;
    ulLiWitd = $('.swiper_Myslide li').outerWidth();
    ulWith = $('.swiper_Myslide li').length * ulLiWitd;
    ulWiths = ulWith * 3;
    $('.swiper_Myslide').width(ulWiths);
    ulLeft = -ulWith;
    ulJidian = -ulWith * 2;
    index = ulLen;

    $(".swiper_Myslide").animate({
        left: -ulWith
    }, 0);
    $('.swiper_Myslide li:lt(' + ulLen + ')').clone(true).prependTo(".swiper_Myslide").appendTo(".swiper_Myslide");
    $('.swiper_Myslide li:lt(' + ulLen + ')').clone(true).appendTo(".swiper_Myslide");
    $('.swiper_Myslide li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
    $('.uldian li:first').addClass('cur').siblings().removeClass('cur');
});

function clock() {
    ulLeft = ulLeft - ulLiWitd;
    index += 1;
    $(".swiper_Myslide").animate({
        left: ulLeft
    }, slide_Time, function() {
        if (ulLeft == ulJidian) {
            $('.swiper_Myslide li:lt(' + ulLen + ')').remove().clone(true).appendTo(".swiper_Myslide");
            $(".swiper_Myslide").animate({
                left: -ulWith
            }, 0);
            ulLeft = -ulWith;
            index = ulLen;
        }
        $('.swiper_Myslide li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        indexs = index - ulLen;
        $('.uldian li:eq(' + indexs + ')').addClass('cur').siblings().removeClass('cur');
    });
}
$(document).ready(function() {
    $('.swiper_but_next').click(function() {
        ulLeft = ulLeft - ulLiWitd;
        index += 1;
        indexs = index - ulLen;
        $('.uldian li:eq(' + indexs + ')').addClass('cur').siblings().removeClass('cur');
        $('.swiper_Myslide').stop().animate({
            left: ulLeft
        }, slide_Time, function() {
            $('.swiper_Myslide li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        });
        if (ulLeft == ulJidian) {
            $('.swiper_Myslide li:lt(' + ulLen + ')').remove().clone(true).appendTo(".swiper_Myslide");
            $(".swiper_Myslide").animate({
                left: -ulWith
            }, 0);
            ulLeft = -ulWith;
            index = ulLen;
        }
        clearInterval(int);
        int = setInterval(clock, time);
    });
});
$(document).ready(function() {
    $('.swiper_but_prev').click(function() {
        ulLeft += ulLiWitd;
        index -= 1;
        indexs = index - ulLen;
        $('.uldian li:eq(' + indexs + ')').addClass('cur').siblings().removeClass('cur');
        $('.swiper_Myslide').stop().animate({
            left: ulLeft
        }, slide_Time, function() {
            $('.swiper_Myslide li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        });
        if (ulLeft == 0) {
            $('.swiper_Myslide li:lt(' + ulLen + ')').remove().clone(true).appendTo(".swiper_Myslide");
            $(".swiper_Myslide").animate({
                left: -ulWith
            }, 0);
            ulLeft = -ulWith;
            index = ulLen;
        }
        clearInterval(int);
        int = setInterval(clock, time);
    });
});
$(document).ready(function() {
    $('.uldian li').hover(function() {
        $(this).addClass('cur').siblings().removeClass('cur');
        var liSu = $(this).index();
        index = liSu + ulLen;
        ulLeft = -(ulWith + liSu * ulLiWitd);
        $('.swiper_Myslide').stop().animate({
            left: ulLeft
        }, slide_Time, function() {
            $('.swiper_Myslide li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        });
        clearInterval(int);
    }, function() {
        int = setInterval(clock, time);
    });
});
$(document).ready(function() {
    var swi_butHei = $('.swiper_buttton').height() / 2;
    $('.swiper_buttton').css('margin-top', -swi_butHei);
});

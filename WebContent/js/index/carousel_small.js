//small_carousel
$(document).ready(function() {
    $('.swiper_Myslide_s li').each(function() {
        var ff = $(this).text();
        var index = $(this).index();
        $('.uldian_s').append("<li></li>");
    });
});

$(document).ready(function() {
    $('.swiper_Myslide_s li').width($(window).width());
    time = 3000;
    slide_Time = 500;
    int = self.setInterval("clock()", time);
    ulLen = $('.swiper_Myslide_s li').length;
    ulLiWitd = $('.swiper_Myslide_s li').outerWidth();
    ulWith = $('.swiper_Myslide_s li').length * ulLiWitd;
    ulWiths = ulWith * 3;
    $('.swiper_Myslide_s').width(ulWiths);
    ulLeft = -ulWith;
    ulJidian = -ulWith * 2;
    index = ulLen;

    $(".swiper_Myslide_s").animate({
        left: -ulWith
    }, 0);
    $('.swiper_Myslide_s li:lt(' + ulLen + ')').clone(true).prependTo(".swiper_Myslide_s").appendTo(".swiper_Myslide_s");
    $('.swiper_Myslide_s li:lt(' + ulLen + ')').clone(true).appendTo(".swiper_Myslide_s");
    $('.swiper_Myslide_s li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
    $('.uldian_s li:first').addClass('cur').siblings().removeClass('cur');
});

function clock() {
    ulLeft = ulLeft - ulLiWitd;
    index += 1;
    $(".swiper_Myslide_s").animate({
        left: ulLeft
    }, slide_Time, function() {
        if (ulLeft == ulJidian) {
            $('.swiper_Myslide_s li:lt(' + ulLen + ')').remove().clone(true).appendTo(".swiper_Myslide_s");
            $(".swiper_Myslide_s").animate({
                left: -ulWith
            }, 0);
            ulLeft = -ulWith;
            index = ulLen;
        }
        $('.swiper_Myslide_s li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        indexs = index - ulLen;
        $('.uldian_s li:eq(' + indexs + ')').addClass('cur').siblings().removeClass('cur');
    });
}
$(document).ready(function() {
    $('.uldian_s li').hover(function() {
        $(this).addClass('cur').siblings().removeClass('cur');
        var liSu = $(this).index();
        index = liSu + ulLen;
        ulLeft = -(ulWith + liSu * ulLiWitd);
        $('.swiper_Myslide_s').stop().animate({
            left: ulLeft
        }, slide_Time, function() {
            $('.swiper_Myslide_s li:eq(' + index + ')').addClass('active').siblings().removeClass('active');
        });
        clearInterval(int);
    }, function() {
        int = setInterval(clock, time);
    });
});
$(document).ready(function() {
    var swi_butHei = $('.swiper_buttton_s').height() / 2;
    $('.swiper_buttton_s').css('margin-top', -swi_butHei);
});
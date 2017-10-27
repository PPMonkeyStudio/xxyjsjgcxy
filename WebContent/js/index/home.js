function stopPropagation(e) {
	if (e.stopPropagation)
		e.stopPropagation();
	else
		e.cancelBubble = true;
}
//navlist
$('#navList').on('mouseover', '.nav-btn', function(event) {
	if ($(this).hasClass('btn-active')) {
		$('#expandZone').click();
		return false;
	}
	$(this).addClass('btn-active').siblings().removeClass('btn-active');
	if ($(".navlist a").index(this) > 0){
		$(this).parent().parent().next().children().children().eq(($(".navlist a").index(this))-1).addClass('item-active').siblings().removeClass('item-active');
		$('#expandZone').stop().animate({
			height: '195px'
		}).addClass('active');
	}else{
		$('#expandZone').stop().animate({
			height: '0px'
		}).addClass('active');
	}
	
	return false;
});

$(document).bind('mouseover', function() {
	$('#expandZone').stop().animate({
		height: '0px'
	}, 0, function() {
		$(this).removeClass('active');
		$('#navList .btn-active').removeClass('btn-active');
	});
});

$('#expandZone').bind('mouseover', function(e) {
	stopPropagation(e);
});
function getNewsCategory(select) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var json = JSON.parse(xhr.responseText);
				for ( var num in json) {
					var option = document.createElement("option");
					option.appendChild(document
							.createTextNode(json[num].category_name));
					select.appendChild(option);
					option.value = json[num].jsj_snews_category_id;

					var span_news_category = document
							.getElementById("span_news_category");
					if (span_news_category != null) {
						if (span_news_category.innerHTML == json[num].jsj_snews_category_id) {
							option.selected = true;
						}
					}
				}
				$('#' + select.id).selectpicker('refresh');

			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/snews/category_listCategoryRankTwo");

	xhr.send(null);

}

function getNews(select) {
	
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var json = JSON.parse(xhr.responseText);

				for ( var num in json) {

					var option = document.createElement("option");
					option.appendChild(document
							.createTextNode(json[num].news_title));
					select.appendChild(option);
					option.value = json[num].jsj_snews_news_id;

					var span_category_news = document
							.getElementById("span_category_news");
					if (span_category_news != null) {
						if (span_category_news.innerHTML == json[num].jsj_snews_news_id) {
							option.selected = true;
						}
					}
				}
				$('#' + select.id).selectpicker('refresh');

			} else {
				toastr.error(xhr.status);
			}
		}
	}
	xhr.open("POST", "/xxyjsjgcxy/snews/news_listNewsAll");
	xhr.send(null);

}
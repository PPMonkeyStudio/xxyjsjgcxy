function update_name() {
	var input_add = document.getElementById("input_add");
	if (input_add.value != "") {
		toastr.success(input_add.value);
		var name = input_add.value.split(";");
		for (var i = 0; i < name.length; i++) {
			input_add.value = name[i];
			add_name();
		}
	}
}


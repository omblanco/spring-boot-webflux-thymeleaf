function GeonameController() {

	this._init();
}

GeonameController.prototype._init = function() {
    $('#myTab a').on('click', function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    });
};

$(document).ready(function() {
	new GeonameController();
});
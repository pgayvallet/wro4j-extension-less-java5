var lessIt = function(css) {
    var result;
    var parser = new less.Parser({ optimization: 2 });

    parser.parse(css, function (e, root) {
    	if (e) {
       		throw e;    		
    	}
    	result = css;
   		result = root.toCSS();
    });
    return result;
};

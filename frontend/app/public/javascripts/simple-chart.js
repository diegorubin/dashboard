var SimpleChart = function(container, title) {
  var _this = this;
  _this.dois = true;
  _this.chart = new Highcharts.Chart({
        chart: {
            renderTo: container,
            type: 'column',
        },
        xAxis: {
          categories: []
        },
        title: {
            text: title
        },
        series: []
    });
}

SimpleChart.prototype.loadInitialData = function() {
  var _this = this;
  $.ajax({
    url: '/charts/orders'
  }).done(function(result){
    var data = [];
    var categories = [];

    for (var key in result.series) {
      categories.push(key);
      data.push(result.series[key])
    }

    _this.chart.xAxis[0].setCategories(categories);
    _this.chart.addSeries({
      name: result.name,
      data: data
    });
  });
}

SimpleChart.prototype.update = function(point, value) {
  var _this = this;
  var last = _this.chart.series[0].data.length - 1;
  _this.chart.series[0].data[last].update(value);
}


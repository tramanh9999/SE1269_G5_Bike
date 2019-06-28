$(document).ready(function () {

  $('#loadmaster').bind("click", function () {
    api_master="http://hirebike.herokuapp.com/bikehire/bikes/all";
    $.ajax({
      xhrFields: {
        withCredentials: true
      },
      type: "GET",
      url: api_master
    }).done(function (data) {
      populateTable(data);
    });
  });
  $('#loaddev').bind("click", function () {
    $.ajax({
      xhrFields: {
        withCredentials: true
      },
      type: "GET",
      url: "http://dev-hirebike.herokuapp.com/bikehire/bikes/all"
    }).done(function (data) {
      populateTable(data);
    });
  });



  function populateTable(data) {
    $('#biketable').dynatable(
      {
        table: {
          defaultColumnIdStyle: 'camelCase'
        },
        dataset: {
          records: data

        }
      }
    );

  }

})

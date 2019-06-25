$.getJSON(
    {
        url: "http://dev-hirebike.herokuapp.com/bikehire/bikes/all",
        success: function (data) {
var items=[];
items=data;
console.log(items[0]);
        }

    }
)
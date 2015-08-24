$(document).ready(function() {
    
    $("#pretraga").keyup(function() {
        var value = $(this).val();
        if(value!=""){
            // display current available
            $.ajax({
                url: 'services/RoomFinder?name=' + value,
                data: {
                    name: value
                },
                success: function(data) {
                    $('#table').empty();
                    $('#table').append(data);
                }
            });
        } else {
            // display init page
            $.ajax({
                url: 'services/Pagination?page=1',
                success: function(data) {
                    $("#table").empty();
                    $("#table").append(data);
                    $(".callservice").bind("click", handler);
                }
            });
        }
    });
    
    var handler = function() {
        $.ajax({
            url: 'services/Pagination?page=' + $(this).text(),
            success: function (data) {
                $('#table').empty();
                $('#table').append(data);
                $(".callservice").bind("click", handler);
            }
        });
    };
    
    // default page
    $.ajax({
        url: 'services/Pagination?page=1',
        success: function(data) {
            $("#table").empty();
            $("#table").append(data);
            $(".callservice").bind("click", handler);
        }
    });
});
    
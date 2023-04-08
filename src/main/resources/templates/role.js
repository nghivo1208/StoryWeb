$(document).ready(function(){

    $('#btn-login-facebook').click(function (e){
        e.preventDefault()
        //logic code
        //$(this) đại diện cho chính element mà mình đang click
        // const name = $('#name').val()
        // const desc = $('#desc').val()
      
        $.ajax({
            method: "POST",
            url: `http://localhost:8080/signin/facebook`,

        }).done(function (data){
            // if (data.data){
            //     console.log('add thanh cong')
            // }else{
            //     console.log('add that bai')
            // }
        })
    })
})
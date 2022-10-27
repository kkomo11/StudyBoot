$("#all").click(function() {
    let ch = $(this).prop("checked");
    $('.check').prop("checked", ch);
});

$('.check').click(function() {
    let flag=true;
    $('.check').each(function(index,item) {
        let ch = $(item).prop("checked");
        if(!ch) {
            flag=false;
        }
    })
    $('#all').prop("checked", flag);
});

$('#btnJoin').click(function() {
    let chkId=true;
    let chkPw=true;
    let chkName=true;
    let chkEmail=true;

    if($('#id').val()=='') chkId=false;
    if(($('#pw').val() != $('#pw2').val()) || $('#pw').val()=='') chkPw=false;
    if($('#name').val()=='') chkName=false;
    if($('#email').val()=='') chkEmail=false;
    if(chkId && chkPw && chkName && chkEmail) {
        $('#frmJoin').submit();
    } else {
        alert('입력해');
    }
})

//id,pw,pw2Equals,name,email
let results = [false,false,false,false,false,false];


//ID Check
$("#id").blur(function(){
    let id = $('#id').val();
    let result = nullCheck(id, "#check_id", "아이디")
    results[0]=result

    //단 id가 빈String이 아닐 때로 분기처리
    if(result) {
        $.get('./idCheck?id='+id, function(data) {
            if(data=='0') {
                results[0]=true;
            } else {
                results[0]=false;
                $("#check_id").html("아이디 중복");
            }
        });
    }
});

$("#pw").on({
    blur : function(){
        let result = nullCheck($("#pw").val(),"#check_pw","비밀번호")
        results[1]=result
    },
    change :function(){
        let result = equals($("#pw").val(),$("#pw2").val());
        if($("#pw").val()==""){
            $("#check_pw2").html("");
        }else if(result){
            $("#check_pw2").html("");
        }else{
            $("#check_pw2").html("아니 비밀번호가 바꼈잖아요;.")
        }
        results[5]=result;
    }
});

//pw Equal Check
$("#pw2").blur(function(){
    let result = equals($("#pw").val(),$("#pw2").val())
    console.log("result pw2: ", result)
    
    if(result){
        $("#check_pw2").html("");
    }else{
        $("#check_pw2").html("비밀번호가 틀립니다.")
    }
    results[2]=result
});

//name Check
$("#name").blur(function(){
    let result = nullCheck($("#name").val(),"#check_name","이름")
    results[3]=result
})

//email Check
$("#email").blur(function(){
    let result = nullCheck($("#email").val(),"#check_email","이메일")
    results[4]=result
})

$("#joinButton").click(function(){
    if(results.includes(false)){
        alert("필수 입력은 다 입력하시오")
    }else{
        alert("전송")
        // $("#joinForm").submit();
    }
});

$("#test").click(function() {
    let id='123';
    let name='iu';
    $.post("./test", {id:id, name:name}, function(result) {
        console.log(result);
        console.log(result.name);
    })
})

$("#test2").click(function() {
    let id='abcd';
    $.ajax({
        type:"GET",
        url:"idCheck",
        data:{
            id:id
        },
        success:function(data) {
            console.log(data);
        },
        error:function(xhr, status, error) {
            console.log('Xhr : ', xhr);
            console.log('Status : ', status);
            console.log('Error : ', error);
        }
    })
})

$("#test3").click(function() {
    let id='123';
    let name='iu';
    let ar=[1,2,3];
    $.ajax({
        type:"POST",
        url:"test",
        traditional:true,   //배열을 전송할때 사용, true값 사용하면됨
        data:{
            id:id,
            name:name,
            ar:ar
        },
        success:function(data) {
            console.log(data);
        }
    })
})

let count=3;
$("#s1Add").click(function() {
    let add = '<option>'+count+'</option>';
    count++;
    $("#s1").append(add);
})
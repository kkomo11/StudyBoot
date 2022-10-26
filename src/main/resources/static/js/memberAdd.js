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
    let result = nullCheck($("#id").val(), "#check_id", "아이디")
    results[0]=result
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
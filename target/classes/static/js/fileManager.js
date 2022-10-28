let count=0;
$("#btnFileAdd").click(function() {
    if(flag) {
        console.log(flag);
        let size=$('#fileWrap').attr("data-file-size");
        if(size==undefined) size=0;
        count=size;
        flag=false;
    }
    if(count>=5) return;
    let file = '<div class="input-group mb-3"><input type="file" class="form-control" name="files" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"><button type="button" class="del">X</button></div>';
    count++;
    $("#fileWrap").append(file);
});

function setCount(c) {
    if(c<1 || c>5) {
        c=1
    }
    count=c;
}

$("#fileWrap").on("click", ".del", function() {
    $(this).parent().remove();
    count--;
});

let flag=true;
$(".deleteFile").click(function() {
    const btn = $(this);
    if(flag) {
        console.log(flag);
        let size=$('#fileWrap').attr("data-file-size");
        count=size;
        flag=false;
    }
    let check = confirm("삭제 하시겠습니까?");
    if(check) {
        let fileNum = $(this).attr("data-file-num");
        $.ajax({
            type:"POST",
            url:"/qna/fileDelete",
            data:{
                fileNum:fileNum
            },
            success:function(data){
                if(data) {
                    // $(this).parent().remove(); this가 달라서 사용X
                    btn.parent().remove();
                    count--;
                }
            }
        })
    }
});
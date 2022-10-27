let count=1;
$("#btnFileAdd").click(function() {
    if(count>5) return;
    let file = '<div class="input-group mb-3"><input type="file" class="form-control" name="files" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"><button type="button" class="del">X</button></div>';
    count++;
    $("#fileWrap").append(file);
});

$("#fileWrap").on("click", ".del", function() {
    $(this).parent().remove();
    count--;
});

$(".deleteFile").click(function() {
    const btn = $(this);
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
                }
            }
        })
    }
});
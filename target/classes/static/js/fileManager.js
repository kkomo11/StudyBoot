let count=1;
$("#btnFileAdd").click(function() {
    if(count>5) return;
    let file = '<div class="input-group mb-3"><input type="file" class="form-control" name="files" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"></div>';
    count++;
    $("#fileWrap").append(file);
})
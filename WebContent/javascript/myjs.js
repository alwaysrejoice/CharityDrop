window.onload = function() {
    var files = document.querySelectorAll("input[type=file]");
    files[0].addEventListener("change", function(e) {
                              if(this.files && this.files[0]) {
                              var reader = new FileReader();
                              reader.onload = function(e) { document.getElementById("preview").setAttribute("src", e.target.result); }
                              reader.readAsDataURL(this.files[0]);
                              }
                              });
}

function disable(){
    if(document.getElementById("alt-addr").disabled==true){
        document.getElementById("alt-addr").disabled= false;
        document.getElementById("alt-city").disabled= false;
        document.getElementById("alt-state").disabled= false;
        document.getElementById("alt-zip").disabled= false;
    }else{
        document.getElementById("alt-addr").disabled= true;
        document.getElementById("alt-city").disabled= true;
        document.getElementById("alt-state").disabled= true;
        document.getElementById("alt-zip").disabled= true;
    }
}
function checkForm(form)
{
    var re;
    if(form.password.value != "" && form.password.value == form.cpassword.value) {
        if(form.password.value.length < 8) {
            alert("Error: Password must contain at least eight characters!");
            form.password.focus();
            return false;
        }
        if(form.password.value.length > 128){
            alert("Error: Password only can contain at most 128 characters!");
            form.password.focus();
            return false;
        }
        if(form.password.value == form.uid.value) {
            alert("Error: Password must be different from Username!");
            form.password.focus();
            return false;
        }
        re = /[0-9]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one number (0-9)!");
            form.password.focus();
            return false;
        }
        re = /[a-z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one lowercase letter (a-z)!");
            form.password.focus();
            return false;
        }
        re = /[A-Z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one uppercase letter (A-Z)!");
            form.password.focus();
            return false;
        }
    } else {
        alert("Error: Please check that you've entered and confirmed your password!");
        form.password.focus();
        return false;
    }
    
    alert("You entered a valid password: " + form.password.value);
    return true;
}
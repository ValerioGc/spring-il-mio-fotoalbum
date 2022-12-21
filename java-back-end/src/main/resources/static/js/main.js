
function deleteConfirmation() {
  confirm("Vuoi davvero eliminare la foto?");
}

function showOption() {
	let us = document.getElementById("userBar")
	us.addEventListner('click', () =>{
		 document.getElementById("userOpt").classList.remove('d-none');
	})
}
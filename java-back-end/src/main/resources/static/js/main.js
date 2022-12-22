
function deleteConfirmation(el) {
  confirm("Vuoi davvero eliminare la " + el + " ?");
}

function showOption() {
	let us = document.getElementById("userBar")
	us.addEventListner('click', () =>{
		 document.getElementById("userOpt").classList.remove('d-none');
	})
}
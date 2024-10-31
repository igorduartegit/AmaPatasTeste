/**
 * Confirmar exclusao de um contato
 * 
 * @author Igor Duarte
 * @param {*} idcon 
 */

 function confirmar(idcon){
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		alert('Contato apagado!')
		window.location.href = "delete?idcon=" + idcon
	}
 }
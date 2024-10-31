/* Validar campos obrigatorios
 * 
 * @author Igor Duarte
 */

 function validar(){
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let apoiador = frmContato.apoiador.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone==="") {
		alert('Preencha o campo Telefone')
		frmContato.fone.focus()
		return false
	} else if (!apoiador.includes("adotar") && !apoiador.includes("doar")
		 && !apoiador.includes("apadrinhar") && !apoiador.includes("Adotar")
		 && !apoiador.includes("Doar") && !apoiador.includes("Apadrinhar")) {
	alert('Você deve escolher entre "Doar", "Adotar" ou "Apadrinhar')
		frmContato.apoiador.focus()
		return false
			
	} else {
		document.forms["frmContato"].submit()
		alert('Contato registrado!')
	}
 }
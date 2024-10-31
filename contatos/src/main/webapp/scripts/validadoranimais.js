/** /* VALIDADOR DE ANIMAIS 
 * Validar campos obrigatorios
 * 
 * @author Igor Duarte
 */

 function validarAnimais(){
	let nomepet = frmAnimais.nomepet.value
	let especie = frmAnimais.especie.value
	let sexo = frmAnimais.sexo.value
	let idade = frmAnimais.idade.value
	let situacao = frmAnimais.situacao.value
	if (nomepet === "") {
		alert('Preencha o campo Nome')
		frmAnimais.nomepet.focus()
		return false
	} else if (especie ==="") {
		alert('Preencha o campo Espécie')
		frmAnimais.especie.focus()
		return false
	} else if (sexo ==="") {
		alert('Preencha o campo Sexo')
		frmAnimais.sexo.focus()
		return false
	} else if (idade ==="") {
		alert('Preencha o campo Idade')
		frmAnimais.idade.focus()
		return false
	} else if (!situacao.includes("Adotado") && !situacao.includes("Disponivel")
		 && !situacao.includes("Apadrinhado")) {
	alert('Você deve escolher entre "Adotado", "Disponivel" ou "Apadrinhado')
		frmAnimais.situacao.focus()
		return false
			
	} else {
		document.forms["frmAnimais"].submit()
		alert('Animal registrado!')
	}
 }
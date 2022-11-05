function GerarMatricula() {
  let txt = 'ACA'
  let ale = Math.floor(Math.random() * 1500)

  document.getElementById('matricula').value = txt + ale
}

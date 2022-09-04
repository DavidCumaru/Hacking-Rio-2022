


function cadastraLogin() {
  event.preventDefault()
  const url = "http://localhost:8080/logins"
  const email = document.getElementById("emailCadastro").value
  const senha = document.getElementById("senhaCadastro").value
  
  const cadastro = {
    "email": email,
    "senha": senha
  }
  const options = {
  method: 'POST',
  headers: {
    "Content-Type" : "application/json"
    },
    body: JSON.stringify(cadastro)
  } 
  
  fazPost(url,options)
}


function fazPost(url, options){
  fetch(url,options)
  .then(response=>response.json())
  .then(json=>console.log(json))
}


function fazLogin() {
  event.preventDefault()
  const url = "http://localhost:8080/logins"
  const email = document.getElementById("emailLogin").value
  const senha = document.getElementById("senhaLogin").value

  const login = {
    "email": email,
    "senha": senha
  }
  const options = {
  method: 'POST',
  headers: {
    "Content-Type" : "application/json"
    },
    body: JSON.stringify(login)
  } 
  
  fazPost(url,options)
}
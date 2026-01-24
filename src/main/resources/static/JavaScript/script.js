/*=========================<LES LIVRES>=========================*/
//function: afficher les livres
 function displayBook (book){
     //la table qui contient tous les livres
     let tableBook = document.createElement("table");
     tableBook.setAttribute("id","tablebook");
     let divcontenu = document.getElementById("contenu");
     

    //les tr de la table
    let tr1 = document.createElement("tr");
    let tr2= document.createElement("tr"); 

     //l id du livre
     let id_th= document.createElement("th");
     let id_td= document.createElement("td");
     id_th.textContent="Identifiant";
     id_td.textContent=book.Id;
    
     tr1.appendChild(id_th);
      tr2.appendChild(id_td);
    

    //le titre du livre
    
    let th_title = document.createElement("th");
    th_title.textContent="Titre";
    let td_title = document.createElement("td")
    td_title.textContent=book.title;
    tr1.appendChild(th_title);
    tr2.appendChild(td_title);
   
   
    //l'auteur du livre
    
    let th_author = document.createElement("th");
    th_author.textContent=" Auteur" ;
    let td_author = document.createElement("td");
    td_author.textContent=book.author;
    tr1.appendChild(th_author); 
    tr2.appendChild(td_author);
  

    // l'Isbn du livre
   
    let th_isbn = document.createElement("th");
    th_isbn.textContent="Isbn ";
    let td_isbn = document.createElement("td");
    td_isbn.textContent=book.isbn;
    tr1.appendChild(th_isbn);
    tr2.appendChild(td_isbn);
    
   

    //l'annee de publication du livre
   
    let th_year_published = document.createElement("th");
    th_year_published.textContent="Année de publication ";
    let td_year_published = document.createElement("td");
    td_year_published.textContent=book.year_published;
    tr1.appendChild(th_year_published); 
    tr2.appendChild(td_year_published);
    
    
    //la categorie du livre
    
    let th_categorie = document.createElement("th");
    th_categorie.textContent="Genre ";
    let td_categorie = document.createElement("td");
    td_categorie.textContent=book.categories;
    tr1.appendChild(th_categorie);
    tr2.appendChild(td_categorie);

    
     tableBook.appendChild(tr1);
     tableBook.appendChild(tr2);
     divcontenu.appendChild(tableBook);

 }

// fetch des  livres 
let  button = document.getElementById("button-header1")
button.addEventListener('click', function () {
    //vider le dom apres afficher si on click sur un autre boutton      
   

fetch("http://localhost:8080/book/all")
.then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
})
.then(json=>{
    for(let book of json){
      
      displayBook(book);        
    }
})
.catch(error =>{
    console.error(error);
})
 document.getElementById("contenu").innerHTML = "";
});

//cherhcer par titre de livre

document.getElementById("button-search").addEventListener("click", function () {

    let titrerechercher = document.getElementById("search").value;
    console.log(titrerechercher);
     fetch("http://localhost:8080/book/title/"+titrerechercher)
   .then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
   })
   .then(json=>{
    for(let book  of json){
      
      displayBook(book);     
    }
   })
  .catch(error =>{
    console.error(error);
   })
   document.getElementById("search").value = ""; 
 document.getElementById("contenu").innerHTML = "";
});


//chercher un livre apr categorie
document.getElementById("filtrer").addEventListener("click", function () {

    let categorieRechercher = document.getElementById("filtrer-categorie").value;
     fetch("http://localhost:8080/book/categorie/"+categorieRechercher)
   .then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
   })
   .then(json=>{
    for(let book  of json){
      
      displayBook(book);     
    }
   })
  .catch(error =>{
    console.error(error);
   })
 
 document.getElementById("contenu").innerHTML = "";
});

/*=========================<LES MEMBRES>=========================*/

//afficher tt les membres
function displayMembers(members){
   
     //la table qui contient tous les membres
     let tableMembers = document.createElement("table");
     tableMembers.classList.add("tablemembers")
     let divcontenu = document.getElementById("contenu");

     divcontenu.appendChild(tableMembers);

     //l'id du memmbre
     let id = document.createElement("tr");
     id.classList.add("members-id");
     id.textContent="Identifiant: "+ members.id;
     tableMembers.appendChild(id);

     //le nom du membre
     let name = document.createElement("tr");
     name.classList.add("name");
     name.textContent="Nom: "+ members.name_;
     tableMembers.appendChild(name);

     //le prenom du membre  
        let first_name = document.createElement("tr");  
        first_name.classList.add("first_name");
        first_name.textContent="Prénom: "+ members.first_name;
        tableMembers.appendChild(first_name);
        //l'email du membre
        let email = document.createElement("tr");
        email.classList.add("email");
        email.textContent="Email: "+ members.e_mail;
        tableMembers.appendChild(email);   
        //le telephone du membre
        let phone = document.createElement("tr");
        phone.classList.add("phone");
        phone.textContent="Téléphone: "+ members.telephone ;
        tableMembers.appendChild(phone);

        //registration_date du membre       
        let registration_date = document.createElement("tr");   
        registration_date.classList.add("registration_date");
        registration_date.textContent="Date d'inscription: "+ members.registration_date;
        tableMembers.appendChild(registration_date);   
        //l'etat du membre active_ ou non
        let active_ = document.createElement("tr");  
        active_.classList.add("active_");
        active_.textContent="Statut: "+ members.active_ ;
        tableMembers.appendChild(active_); 
     
}

// fetch des membres

document.getElementById("button-header2").addEventListener('click', function () {

fetch("http://localhost:8080/members/all")
.then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
})
.then(json=>{
    for(let members of json){
      
      displayMembers(members);        
    }
})
.catch(error =>{
    console.error(error);
})

 document.getElementById("contenu").innerHTML = "";
});


/*=========================<LES EMPRUNTS>=========================*/

//afficher tt les emprunts  

function displayBorrow(borrow,late){
    
     //la table qui contient tous les emprunts  
     let tableBorrow    = document.createElement("table");
     tableBorrow.classList.add("tableBorrow");
     let divcontenu = document.getElementById("contenu");
     divcontenu.appendChild(tableBorrow);
        
        


        //book_id du livre emprunté
        let book_id = document.createElement("tr");  
        book_id.classList.add("book-id-borrow");
        book_id.textContent="Id du livre: "+ borrow.book_id;
        tableBorrow.appendChild(book_id);

        //members_id du membre qui a emprunté
        let members_id = document.createElement("tr");  
        members_id.classList.add("members-id-borrow");
        members_id.textContent="Id du membre : "+ borrow.members_id;
        tableBorrow.appendChild(members_id);
        //borrow_date date d'emprunt
        let borrow_date = document.createElement("tr");  
        borrow_date.classList.add("borrow_date");   
        borrow_date.textContent="Date d'emprunt: "+ borrow.borrow_date;
        tableBorrow.appendChild(borrow_date);
        //expected_return_date date de retour prévue
        let expected_return_date = document.createElement("tr");  
        expected_return_date.classList.add("expected_return_date"); 
        expected_return_date.textContent="Date de retour prévue: "+ borrow.expected_return_date;
        tableBorrow.appendChild(expected_return_date);
        //effective_return_date date de retour effective
        let effective_return_date = document.createElement("tr");  
        effective_return_date.classList.add("effective_return_date"); 
        effective_return_date.textContent="Date de retour effective: "+ borrow.effective_return_date;
        tableBorrow.appendChild(effective_return_date); 
        //nombre de jours en retard
        if(late)
        {
         let td = document.createElement("tr");
        td.classList.add("tr-dayOfLate");

        let tr =document.createElement("td");
        tr.classList.add("td-dayOfLate")

       let date1= new Date();
       let expected_date= new Date(borrow.expected_return_date).getTime();
       const msPerDay =1000*60*60*24;
       let numberDayOf = Math.floor((date1-expected_date)/msPerDay);
       
       tr.textContent="nombre de jour en retard: "+numberDayOf;
       td.appendChild(tr);
       tableBorrow.appendChild(td);
        }


        
       
}


//fetch des emprunts

//afficher tt les emprunts en cours
document.getElementById("button-header3").addEventListener('click', function () {
//une entete de la colonne
        let tableBorrow    = document.createElement("table");
        tableBorrow.classList.add("tableBorrow");
        let divcontenu = document.getElementById("contenu");
        divcontenu.appendChild(tableBorrow);

        let entete = document.createElement("th");
        entete.classList.add("entete")
        entete.textContent="les emprunts en cours";
        tableBorrow.appendChild(entete);


        fetch("http://localhost:8080/borrow/inprogress")
.then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
})
.then(json=>{
    console.log(json)
    for(let borrow  of json){
    
      displayBorrow(borrow,false)
     
    }
})
.catch(error =>{
    console.error(error);
})
 document.getElementById("contenu").innerHTML = ""; 

})


//afficher tt les emprunts en retard


document.getElementById("button-late").addEventListener('click', function () {

        let tableBorrow    = document.createElement("table");
        let divcontenu = document.getElementById("contenu");
        divcontenu.appendChild(tableBorrow);

fetch("http://localhost:8080/borrow/islate")
.then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
})
.then(json=>{
    console.log(json)
    for(let borrow  of json){
      
      
      displayBorrow(borrow,true);  
      
     
    }
})
.catch(error =>{
    console.error(error);
})
 document.getElementById("contenu").innerHTML = ""; 

})

//afficher tt les emprunts d'un membre

document.getElementById("emprunt-search").addEventListener("click", function () {

    let idMEMBER= document.getElementById("emprunt").value;
     fetch("http://localhost:8080/borrow/member/"+idMEMBER)
   .then(response =>{
    if(!response.ok){
        throw new Error("Error server");
    }
    return response.json();
   })
   .then(json=>{
    console.log(json)
    document.getElementById("contenu").textContent = json.name_ +" "+json.first_name;
   
    for(let borrow  of json.listBorrowDto){
      
      displayBorrow(borrow);     
    }
   })
  .catch(error =>{
    console.error(error);
   })
   document.getElementById("emprunt").value = ""; 
 document.getElementById("contenu").innerHTML = "";
});

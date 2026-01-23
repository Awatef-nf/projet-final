/*=========================<LES LIVRES>=========================*/
//function: afficher les livres
 function displayBook (book){
     //la table qui contient tous les livres
     let tableBook = document.createElement("table");
     tableBook.setAttribute("id","tablebook");
     let divcontenu = document.getElementById("contenu");
     divcontenu.appendChild(tableBook);
     //l id du livre
     let id = document.createElement("tr");
     id.classList.add("book-id");
     id.textContent="Identifiant: "+ book.Id;
     tableBook.appendChild(id);
    
    //le titre du livre
    let title = document.createElement("tr");
    title.classList.add("titre");
    title.textContent="Titre: "+ book.title;
    tableBook.appendChild(title);
   
    //l'auteur du livre
    let author = document.createElement("tr");
    author.classList.add("auteur");
    author.textContent="Auteur: "+ book.author;
    tableBook.appendChild(author);

    // l'Isbn du livre
    let isbn = document.createElement("tr");
    isbn.classList.add("isbn");
    isbn.textContent="ISBN: "+ book.isbn;
    tableBook.appendChild(isbn);

    //l'annee de publication du livre
    let year_published = document.createElement("tr");
    year_published.classList.add("annee");
    year_published.textContent="Année de publication: "+ book.year_published;
    tableBook.appendChild(year_published );
    
    //la categorie du livre
    let categorie = document.createElement("tr");
    categorie.classList.add("categorie");
    categorie.textContent="Genre: "+ book.categories;
    tableBook.appendChild(categorie );
    //ajouter une ligne de séparation entre les livres
    let ligne_separation = document.createElement("hr");
    divcontenu.appendChild(ligne_separation);      
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
       //ajouter une ligne de séparation entre les livres
       let ligne_separation = document.createElement("hr");
       divcontenu.appendChild(ligne_separation);      
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

function displayBorrow(borrow){
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
        
        //ajouter une ligne de séparation entre les livres
       let ligne_separation = document.createElement("hr");
       ligne_separation.classList.add("ligne-separation");
       divcontenu.appendChild(ligne_separation);      
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
    
      displayBorrow(borrow)
     
    }
})
.catch(error =>{
    console.error(error);
})
 document.getElementById("contenu").innerHTML = ""; 

})



//calcule du nombre de jour de retards

function daysOfLate(borrow)
{       let tableBorrow  = document.createElement("table");
        let divcontenu = document.getElementById("contenu");
        divcontenu.appendChild(tableBorrow);
    
    
       let tr = document.createElement("tr");
       tr.classList.add("tr-dayOfLate");
       let td =document.createElement("td");
       td.classList.add("td-dayOfLate")

       let date1= new Date();
       let expected_date= new Date(borrow.expected_return_date).getTime();
       const msPerDay =1000*60*60*24;
       let numberDayOf = Math.floor((date1-expected_date)/msPerDay);
       
       td.textContent="nombre de jour en retard: "+numberDayOf;
       tr.appendChild(td);
       tableBorrow.appendChild(tr);
   
}


//afficher tt les emprunts en retard


document.getElementById("button-late").addEventListener('click', function () {
//une entete de la colonne
        let tableBorrow    = document.createElement("table");
        let divcontenu = document.getElementById("contenu");
        divcontenu.appendChild(tableBorrow);

        let entete = document.createElement("th");
        entete.classList.add("entete")
        entete.textContent="les emprunts en retard";
        tableBorrow.appendChild(entete);

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
      
      daysOfLate(borrow);
      displayBorrow(borrow);  
      
     
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

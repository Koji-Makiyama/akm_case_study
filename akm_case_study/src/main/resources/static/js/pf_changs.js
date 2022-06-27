let btn0 = document.querySelector('#sbtn0');
let btn1 = document.querySelector('#sbtn1');
let btn2 = document.querySelector('#sbtn2');
let btn3 = document.querySelector('#sbtn3');
let btn4 = document.querySelector('#sbtn4');
let btn5 = document.querySelector('#ebtn0');
let btn6 = document.querySelector('#ebtn1');
let btn7 = document.querySelector('#ebtn2');
let btn8 = document.querySelector('#ebtn3');
let btn9 = document.querySelector('#ebtn4');
let btn10 = document.querySelector('#ebtn5');
let btn11 = document.querySelector('#dbtn0');
let btn12 = document.querySelector('#dbtn1');
let btn13 = document.querySelector('#dbtn2');
let btn14 = document.querySelector('#dbtn3');
let btn15 = document.querySelector('#dbtn4');

btn0.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#side1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'No side';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: black; font-weight: bold; background-color: white; border-width: 5px; border-color: blue"); // styles inner-text
    });

btn1.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#side1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Chang\'s Lettuce Wraps';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: blue"); // styles inner-text
});

btn2.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#side1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Edamame';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: blue"); // styles inner-text

});

btn3.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#side1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Handmade Dumplings';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: blue"); // styles inner-text

});

btn4.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#side1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Pork Egg Rolls';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: blue"); // styles inner-text

});

btn5.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'No entree';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: black; font-weight: bold; background-color: white; border-width: 5px; border-color: red"); // styles inner-text
});

btn6.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Orange Chicken';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: red"); // styles inner-text
});


btn7.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Kung Pao Chicken';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: red"); // styles inner-text
});

btn8.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Kung Pao Shrimp';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: red"); // styles inner-text
});

btn9.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Fire Braised Short Ribs';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: red"); // styles inner-text
});

btn10.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#entree1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Beef with Broccoli';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: red"); // styles inner-text
});

btn11.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#dessert1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'No dessert';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: black; font-weight: bold; background-color: white; border-width: 5px; border-color: green"); // styles inner-text
});

btn12.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#dessert1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Chang\'s Apple Crunch';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: green"); // styles inner-text
});

btn13.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#dessert1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'The Great Wall of Chocolate';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: green"); // styles inner-text
});

btn14.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#dessert1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'Banana Spring Rolls';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: green"); // styles inner-text
});

btn15.addEventListener('click', function(event){
    event.preventDefault(); 
    
    let th = document.querySelector('#dessert1');
    console.log("BEFORE INNERTEXT ASSIGNMENT");
    th.innerText = 'New York-Style Cheesecake';                         // set inner-text of table data to the food name
    th.setAttribute("style", "color: white; font-weight: bold; background-color: green"); // styles inner-text
});

document.addEventListener("DOMContentLoaded", function(event){
	document.querySelector("#side1").addEventListener("click", function(event) {
	    event.preventDefault();
        let th = document.querySelector('#side1');	
        th.innerText = '';
});
});

document.addEventListener("DOMContentLoaded", function(event){
	document.querySelector("#entree1").addEventListener("click", function(event) {
	    event.preventDefault();
        let th = document.querySelector('#entree1');	
        th.innerText = '';
});
});

document.addEventListener("DOMContentLoaded", function(event){
	document.querySelector("#dessert1").addEventListener("click", function(event) {
	    event.preventDefault();
        let th = document.querySelector('#dessert1');	
        th.innerText = '';
});
});

function submitPFChangsMeal() {
	let side = document.getElementById('side1').innerText;
	let entree = document.getElementById('entree1').innerText;
	let dessert = document.getElementById('dessert1').innerText;
	console.log(side);
	console.log(entree);
	console.log(dessert);
	let title = document.getElementById('meal-name').value;
	console.log(title);
	window.location.replace("http://localhost:8080/pf_changs/save/" + side + "/" + entree + "/" + dessert + "/" + title);
}

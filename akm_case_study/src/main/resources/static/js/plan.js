function updateName(id, secondParam) {
	console.log(secondParam);
    console.log(id);
	console.log("Name"); // just to check if the method runs (no other purpose)
	//let name = document.getElementById(id).value;
	let name = document.getElementById(secondParam).value;
	console.log(name);
	window.location.replace("http://localhost:8080/plan/update_name/" + name + "/" + id);
}

function updateSide(id, secondParam) {
    console.log(id);
	console.log("Side"); // just to check if the method runs (no other purpose)
	let side = document.getElementById(secondParam).value;
	console.log(side);
	console.log(id);
	window.location.replace("http://localhost:8080/plan/update_side/" + side + "/" + id);
}

function updateEntree(id, secondParam) {
    console.log(id);
	console.log("Entree"); // just to check if the method runs (no other purpose)
	let entree = document.getElementById(secondParam).value;
	console.log(entree);
	console.log(id);
	window.location.replace("http://localhost:8080/plan/update_entree/" + entree + "/" + id);
}

function updateDessert(id, secondParam) {
    console.log(id);
	console.log("Dessert"); // just to check if the method runs (no other purpose)
	let dessert = document.getElementById(secondParam).value;
	console.log(dessert);
	console.log(id);
	window.location.replace("http://localhost:8080/plan/update_dessert/" + dessert + "/" + id);
}
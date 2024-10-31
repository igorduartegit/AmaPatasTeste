document.getElementById('animalForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const age = document.getElementById('age').value;
    const breed = document.getElementById('breed').value;
    const photo = document.getElementById('photo').files[0];
    
    const reader = new FileReader();
    reader.onload = function(e) {
        const photoURL = e.target.result;

        const animalContainer = document.getElementById('animals');

        const animalElement = document.createElement('div');
        animalElement.classList.add('animal');

        const animalImage = document.createElement('img');
        animalImage.src = photoURL;
        animalElement.appendChild(animalImage);

        const animalInfo = document.createElement('div');
        animalInfo.classList.add('animal-info');

        const animalName = document.createElement('h3');
        animalName.textContent = name;
        animalInfo.appendChild(animalName);

        const animalDetails = document.createElement('p');
        animalDetails.textContent = `Idade: ${age} anos | Raça: ${breed}`;
        animalInfo.appendChild(animalDetails);

        animalElement.appendChild(animalInfo);

        animalContainer.appendChild(animalElement);
    }

    reader.readAsDataURL(photo);

    document.getElementById('animalForm').reset();
});

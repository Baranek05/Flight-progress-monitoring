const gridContainer = document.getElementById("atc-grid");
const contentItems = document.querySelectorAll(".atc-entry");
const cellItems = document.querySelectorAll('.atc-field');

document.querySelectorAll("div").forEach( item => {
    item.addEventListener('dragover', event => {
        event.preventDefault();

    })
})

var selectedItem = null;

i = 0
for (const contentItem of contentItems) {
    contentItem.setAttribute('draggable', 'true')
    contentItem.setAttribute('id', `ATC_${i}}`)
    i++;
    contentItem.addEventListener("dragstart", function(event) {
        event.dataTransfer.setData("text", event.target.id);
    });

    contentItem.addEventListener("click", event => {
        if (selectedItem != null) {
            selectedItem.parentNode.classList.remove("atc-selected")
        }
        if (document.getElementById(event.target.id) != selectedItem) {
            selectedItem = document.getElementById(event.target.id)
            selectedItem.parentNode.classList.add("atc-selected")
        } else {
            selectedItem = null
        }
    })
}

for (const cellItem of cellItems) {
    cellItem.addEventListener("drop", function(event) {
        event.preventDefault();
        if (event.target.className === "atc-field") {
            const data = event.dataTransfer.getData("text");  
            const appendedNode = document.getElementById(data);

            const formData = new FormData();
            formData.append('newState', event.target.id);

            fetch(`/updateFlight/${appendedNode.childNodes[1].id}`, {
                method: 'POST',
                body: formData
            }).then( response => {
                console.log(response)
                event.target.appendChild(appendedNode);
            })
        }
    });
}

const deleteItem = document.getElementById("atc-delete");
deleteItem.addEventListener("click", event => {
    if (selectedItem != null) {
        fetch(`/deleteFlight/${selectedItem.id}`, {
            method: 'POST'
        }).then( (response) => {
            console.log(response)
            selectedItem.remove()
        })
    }
})

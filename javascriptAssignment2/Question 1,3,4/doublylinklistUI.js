function Node(value) {
    this.value = value;
    this.prev = null;
    this.next = null;
}

function DoublyLinkedList(){
    this.head = null;
    this.length = 0;
}

DoublyLinkedList.prototype.add = function(){
	var value = document.getElementById("element").value;
	document.getElementById("element").value = "";
    var newNode = new Node(value);
    var currentNode = this.head;

    if(!this.head) {
        this.head = newNode;
    } else {
        while(currentNode.next) {
            currentNode = currentNode.next;
        }
        newNode.prev = currentNode;
        currentNode.next = newNode;
    }
    this.length++;
}

DoublyLinkedList.prototype.removeByIndex = function(indexLocation) {
    if(this.isEmpty()){
        return;
    }
    if(indexLocation < 1 || indexLocation > this.length){
        console.log("Enter valid index to delete");
        return;
    }
    var currentNode = this.head;
    var count = 1;
    if(indexLocation == 1) {
        this.head=currentNode.next;
        currentNode = null;
        this.length--;
        return;
    }
    
    while(count < indexLocation) {
        currentNode = currentNode.next;
        count++;
    }

    if(indexLocation == this.length) {
        currentNode.prev.next = null;
        currentNode = null;
        this.length--;  
        return;  
    }

    currentNode.prev.next = currentNode.next;
    currentNode.next.prev = currentNode.prev;
    currentNode = null;
    this.length--;

}

// function hoisting is depicted here
DoublyLinkedList.prototype.isEmpty = function(){
    if(!this.head) {
        document.getElementById("result").innerHTML = "List is empty";
        return true;
    } else {
        return false;
    }
}

DoublyLinkedList.prototype.display = function() {
    if(this.isEmpty()){
        return;
    }
	var string = "";
    var currentNode = this.head;
    while(currentNode) {
        string += currentNode.value+"<-->";
        currentNode = currentNode.next;
    }
	document.getElementById("result").innerHTML = string;
}

DoublyLinkedList.prototype.removeByValue = function() {
	var valueToRemove = document.getElementById("element").value;
    if(this.isEmpty()){
        return;
    }
    var currentNode = this.head;
    if(currentNode.value === valueToRemove) {
        this.head = currentNode.next;
        currentNode = null;
        this.length--;
        return;
    }
    while(currentNode.value !== valueToRemove && currentNode.next) {
        currentNode = currentNode.next;
    }

    if(!currentNode.next && currentNode.value===valueToRemove){
        currentNode.prev.next = null;
        currentnode = null;
        this.length--;
        return;
    } else if(!currentNode){
        document.getElementById("result").innerHTML = "element not in the list";
        return;
    }
    currentNode.prev.next = currentNode.next;
    currentNode.next.prev = currentNode.prev;
    this.length--;
}
var list = new DoublyLinkedList();
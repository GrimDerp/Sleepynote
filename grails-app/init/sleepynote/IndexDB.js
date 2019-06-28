/* Let's look at an example of the IndexedDB API. In this example we will open a database, add an object store,
and add one item to the object store:
*/

var db;

var openRequest = indexedDB.open('test_db', 1);

openRequest.onupgradeneeded = function(e) {
  var db = e.target.result;
  console.log('running onupgradeneeded');
  if (!db.objectStoreNames.contains('store')) {
    var storeOS = db.createObjectStore('store',
      {keyPath: 'name'});
  }
};
openRequest.onsuccess = function(e) {
  console.log('running onsuccess');
  db = e.target.result;
  addItem();
};
openRequest.onerror = function(e) {
  console.log('onerror!');
  console.dir(e);
};

function addItem() {
  var transaction = db.transaction(['store'], 'readwrite');
  var store = transaction.objectStore('store');
  var item = {
    name: 'banana',
    price: '$2.99',
    description: 'It is a purple banana!',
    created: new Date().getTime()
  };

 var request = store.add(item);

 request.onerror = function(e) {
    console.log('Error', e.target.error.name);
  };
  request.onsuccess = function(e) {
    console.log('Woot! Did it');
  };
}

/*
This code does something very similar to previous examples in this tutorial except that it doesn't use the Promised library.
We can see that the structure of the database interaction hasn't changed. Object stores are created on the database object in
the upgrade event handler, and items are added to the object store in the same transaction sequence we've seen before. 
The difference is that this is done with requests and event handlers rather than promises and promise chains.

Here is a short reference of the differences between the IndexedDB API and the IndexedDB Promised library.

 

IndexedDB Promised

IndexedDB API

Open database

idb.open(name, version, upgradeCallback)

indexedDB.open(name, version)

Upgrade database

Inside upgradeCallback

request.onupgradeneeded

Success

.then

request.onsuccess

Error

.catch

request.onerror
*/



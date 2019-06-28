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

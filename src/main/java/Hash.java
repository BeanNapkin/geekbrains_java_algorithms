public class Hash {

    static class Item {
        private int data;

        public Item(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    static class HashTable {
        private Item[] hashArr;
        private int arrSize;
        private Item nonItem;

        public HashTable(int size) {
            this.arrSize = size;
            this.hashArr = new Item[arrSize];
            nonItem = new Item(-1);
        }

        public void display() {
            for (int i = 0; i < arrSize; i++) {
                if (hashArr[i] != null) {
                    System.out.println(hashArr[i].getData());
                } else {
                    System.out.println("***");
                }
            }
        }

        public int hashFunc(int data) {
            return data % arrSize;
        }

        public int hashFuncDouble(int data) {
            return 5 - data % 5;
        }

        public void insert(Item item) {
            int data = item.getData();
            int hashValue = hashFunc(data);

            while (hashArr[hashValue] != null && hashArr[hashValue].getData() != -1) {
                hashValue = hashValue + 1;
                hashValue = hashValue % arrSize;
            }

            hashArr[hashValue] = item;
        }

        public void insertDoubleHash(Item item) {
            int data = item.getData();
            int hashValue = hashFunc(data);
            int stepSize = hashFuncDouble(data);

            while (hashArr[hashValue] != null && hashArr[hashValue].getData() != -1){
                hashValue = hashValue + stepSize;
                hashValue = hashValue % arrSize;
            }

            hashArr[hashValue] = item;
        }

        public Item delete(int data) {
            int hashValue = hashFunc(data);

            while (hashArr[hashValue] != null) {
                if (hashArr[hashValue].getData() == data) {
                    Item temp = hashArr[hashValue];
                    hashArr[hashValue] = nonItem;
                    return temp;
                }
                hashValue = hashValue + 1;
                hashValue = hashValue % arrSize;
            }

            return null;
        }

        public Item deleteDoubleHash(int data) {
            int hashValue = hashFunc(data);
            int stepSize = hashFuncDouble(data);

            while (hashArr[hashValue] != null) {
                if (hashArr[hashValue].getData() == data) {
                    Item temp = hashArr[hashValue];
                    hashArr[hashValue] = nonItem;
                    return temp;
                }
                hashValue = hashValue + stepSize;
                hashValue = hashValue % arrSize;
            }

            return null;
        }

        public Item find(int data) {
            int hashValue = hashFunc(data);

            while (hashArr[hashValue] != null) {
                if (hashArr[hashValue].getData() == data) {
                    return hashArr[hashValue];
                }
                hashValue = hashValue + 1;
                hashValue = hashValue % arrSize;
            }

            return null;
        }

        public Item findDoubleHash(int data) {
            int hashValue = hashFunc(data);
            int stepSize = hashFuncDouble(data);

            while (hashArr[hashValue] != null) {
                if (hashArr[hashValue].getData() == data) {
                    return hashArr[hashValue];
                }
                hashValue = hashValue + stepSize;
                hashValue = hashValue % arrSize;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.insert(new Item(222));
        hashTable.insert(new Item(505));
        hashTable.insert(new Item(320));
        hashTable.delete(505);

        hashTable.display();
        System.out.println("__________________________");

        HashTable doubleHashTable = new HashTable(10);

        doubleHashTable.insertDoubleHash(new Item(111));
        doubleHashTable.insertDoubleHash(new Item(333));
        doubleHashTable.deleteDoubleHash(333);
        
        doubleHashTable.display();


    }
}

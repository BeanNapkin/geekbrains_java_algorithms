import java.util.ListIterator;

public class MyDequeue<T>  {
    private Item<T> first;
    private Item<T> last;

    public ListIterator<T> iterator() {
        return new Iterator();
    }

    public void addFirst(T data) {
        Item<T> newElement = new Item<>(data);
        if (first == null) {
            first = newElement;
            last = first;
        } else {
            Item<T> old = first;
            first = newElement;
            first.setNext(old);
            old.setPrevious(first);
        }
    }

    public void addLast(T data) {
        Item<T> newElement = new Item<>(data);
        if (last == null) {
            last = newElement;
            first = last;
        } else {
            Item<T> old = last;
            last = newElement;
            old.setNext(last);
            last.setPrevious(old);
        }
    }

    public int size() {
        int size = 1;
        if (first == null) {
            return 0;
        }
        Item<T> current = first;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public T peekFirst() {
        return first != null ? first.getData() : null;
    }

    public T peekLast() {
        return last != null ? last.getData() : null;
    }

    public boolean contains(T data) {
        Item<T> current = first;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void removeLast(){
        last = last.getPrevious();
    }

    public void removeFirst(){
        first = first.getNext();
    }

    private static class Item<T> {
        private final T data;
        private Item<T> next;
        private Item<T> previous;

        Item(T data) {
            this.data = data;
        }

        public Item<T> getNext() {
            return next;
        }

        public void setNext(Item<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Item<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Item<T> previous) {
            this.previous = previous;
        }
    }

    private class Iterator implements ListIterator<T> {

        Item<T> current = null;

        @Override
        public boolean hasNext() {
          if (current == null ){
              return first != null;
          }
              return current.getNext() != null;
        }

        @Override
        public T next() {
            if (current == null){
                current = first;
                return first.getData();
            }
            advance();
            return current.getData();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            Item<T> oldPrevious = current;
            back();
            return oldPrevious.getData();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
           current = null;
        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }

        private void advance() {
            current = current.getNext();
        }

        private void back() {
            current = current.getPrevious();
        }
    }
}

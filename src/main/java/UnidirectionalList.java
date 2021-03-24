
public class UnidirectionalList<T> {
    private Item<T> first;
    private Item<T> last;

    public void addFirst(T data) {
        if (first == null) {
            first = new Item<>(data);
            last = first;
        } else {
            Item<T> old = first;
            first = new Item<>(data);
            first.setNext(old);
        }
    }

    public void addLast(T data) {
        if (last == null) {
            last = new Item<>(data);
            first = last;
        } else {
            Item<T> old = last;
            last = new Item<>(data);
            old.setNext(last);
        }
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

    private static class Item<T> {
        private final T data;
        private Item<T> next;

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
    }
}

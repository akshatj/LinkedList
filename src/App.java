public class App {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(40);
        list.insert(50);

        list.remove(40);

        System.out.println(list.size());

        list.traverseList();
    }
}

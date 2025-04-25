public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        CustomList<String> list1 = new CustomList<>();
        list1.addHead("a nie");
        list1.addTail("sao paulo");
        list1.addHead("trojmiasto");

        System.out.println(list1);
        System.out.println(list1.size());

        list1.add("mobbyn");

        System.out.println(list1);
        System.out.println(list1.size());

        System.out.println(list1.get(1));
    }
}
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int[] nums = {1, 5, 1, 2, 4};

    public static void main(String[] args) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i, nums[i]);
        }

        // 암묵적 형변환 람다식은 런타임에 Compare로 변경돼서 처리되므로 동작은 동일
        Arrays.sort(nodes, (o1, o2) -> {
            int n = (o1.num == o2.num) ? (o1.idx - o2.idx) : (o1.num - o2.num);
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(n);
            return n;
        });

        // 타입을 딱박아놓고 익명함수
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                return (o1.num == o2.num) ? (o1.idx-o2.idx) : o1.num-o2.num;
            }
        });
        System.out.println(Arrays.toString(nodes));
    }

    static class Node {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public String toString() {
            return "num : " + num + " idx : " + idx;
        }
    }
}

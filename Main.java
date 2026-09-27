import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 10000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            System.out.println("=========================================");
            System.out.println("TAMAÑO DE ENTRADA (N): " + n);
            System.out.println("=========================================");

            System.out.println("--- PRUEBAS DE LISTAS ENLAZADAS ---");
            testLists(n, rand);

            System.out.println("\n--- PRUEBAS DE PILAS Y COLAS (ARREGLOS) ---");
            testStackQueue(n, rand);
            
            System.out.println();
        }
    }

    private static void testLists(int n, Random rand) {
        SingleLinkedListNoTail<Integer> slnt = new SingleLinkedListNoTail<>();
        SingleLinkedListWithTail<Integer> slwt = new SingleLinkedListWithTail<>();
        DoubleLinkedListNoTail<Integer> dlnt = new DoubleLinkedListNoTail<>();
        DoubleLinkedListWithTail<Integer> dlwt = new DoubleLinkedListWithTail<>();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) slnt.pushFront(i);
        long end = System.nanoTime();
        System.out.println("SL No Tail - Llenar (PushFront) N=" + n + ": " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) slwt.pushFront(i);
        end = System.nanoTime();
        System.out.println("SL With Tail - Llenar (PushFront) N=" + n + ": " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) dlnt.pushFront(i);
        end = System.nanoTime();
        System.out.println("DL No Tail - Llenar (PushFront) N=" + n + ": " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) dlwt.pushFront(i);
        end = System.nanoTime();
        System.out.println("DL With Tail - Llenar (PushFront) N=" + n + ": " + (end - start) + " ns");

        if (n <= 1000000) {
            int target = rand.nextInt(n);

            start = System.nanoTime();
            slnt.find(target);
            end = System.nanoTime();
            System.out.println("SL No Tail - Find aleatorio: " + (end - start) + " ns");

            start = System.nanoTime();
            dlwt.find(target);
            end = System.nanoTime();
            System.out.println("DL With Tail - Find aleatorio: " + (end - start) + " ns");
        } else {
            System.out.println("* Busqueda omitida por lentitud extrema (O(N) con N=" + n + ")");
        }

        start = System.nanoTime();
        slnt.popFront();
        end = System.nanoTime();
        System.out.println("SL No Tail - PopFront: " + (end - start) + " ns");

        start = System.nanoTime();
        dlwt.popFront();
        end = System.nanoTime();
        System.out.println("DL With Tail - PopFront: " + (end - start) + " ns");
        
        System.out.println("\n(Nota: PushBack/PopBack sin Tail son O(N), por ende muy lentos para N grandes)");
        start = System.nanoTime();
        slwt.pushBack(-1);
        end = System.nanoTime();
        System.out.println("SL With Tail - PushBack (Rapido O(1)): " + (end - start) + " ns");

        start = System.nanoTime();
        dlwt.popBack();
        end = System.nanoTime();
        System.out.println("DL With Tail - PopBack (Rapido O(1)): " + (end - start) + " ns");
    }

    private static void testStackQueue(int n, Random rand) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) stack.push(i);
        long end = System.nanoTime();
        System.out.println("ArrayStack - Llenar (Push) N=" + n + ": " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) queue.enqueue(i);
        end = System.nanoTime();
        System.out.println("ArrayQueue - Llenar (Enqueue) N=" + n + ": " + (end - start) + " ns");

        start = System.nanoTime();
        stack.pop();
        end = System.nanoTime();
        System.out.println("ArrayStack - Pop: " + (end - start) + " ns");

        start = System.nanoTime();
        queue.dequeue();
        end = System.nanoTime();
        System.out.println("ArrayQueue - Dequeue: " + (end - start) + " ns");
    }
}
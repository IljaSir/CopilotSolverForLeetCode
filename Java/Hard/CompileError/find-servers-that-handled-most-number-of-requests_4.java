class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        int[] count = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Ineger> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty) && pq.peek()[0] <= arrival[] {
                int[] a = pq.poll()
       set.add(a[1]);
         
            Integer next = set.ceiling(i % k);
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < profits.length; i++) {
            pq.add(new int[]{capital[i], profits[i]});
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= w) {
                pq2.add(pq.poll()[1]);
            }
            if (pq2.isEmpty()) {
                break;
            }
            w += pq2.poll();
        }
        return w;
    }
}
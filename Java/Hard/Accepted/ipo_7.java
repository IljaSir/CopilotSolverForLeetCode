class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        // use a priority queue to store the available profits
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // use a priority queue to store the capital
        PriorityQueue<int[]> cpq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < profits.length; i++) {
            cpq.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!cpq.isEmpty() && cpq.peek()[0] <= w) {
                pq.add(cpq.poll());
            }
            if (pq.isEmpty()) break;
            w += pq.poll()[1];
        }
        return w;
    }
}
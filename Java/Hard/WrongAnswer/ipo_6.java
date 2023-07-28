class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < profits.length; i++) {
            minHeap.add(i);
        }
        while (k > 0) {
            while (!minHeap.isEmpty() && capital[minHeap.peek()] <= w) {
                maxHeap.add(profits[minHeap.poll()]);
            }
            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll();
            }
            k--;
        }
        return w;
    }
}
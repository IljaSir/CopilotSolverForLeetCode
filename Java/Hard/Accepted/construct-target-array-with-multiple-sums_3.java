class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int num : target) {
            sum += num;
            maxHeap.offer(num);
        }
        while (!maxHeap.isEmpty()) {
            int max = maxHeap.poll();
            sum -= max;
            if (max == 1 || sum == 1) {
                return true;
            }
            if (max < sum || sum == 0 || max % sum == 0) {
                return false;
            }
            max %= sum;
            sum += max;
            maxHeap.offer(max);
        }
        return true;
    }
}
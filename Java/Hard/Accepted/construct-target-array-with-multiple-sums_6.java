class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < target.length; i++) {
            pq.add(target[i]);
            sum += target[i];
        }
        while (true) {
            int max = pq.poll();
            sum -= max;
            if (max == 1 || sum == 1) {
                return true;
            }
            if (max < sum || sum == 0 || max % sum == 0) {
                return false;
            }
            max %= sum;
            sum += max;
            pq.add(max);
        }
    }
}
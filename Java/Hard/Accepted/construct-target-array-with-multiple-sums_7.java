class Solution {
    public boolean isPossible(int[] target) {
        
        int n = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += target[i];
            pq.add(target[i]);
        }
        while (true) {
            int cur = pq.poll();
            sum -= cur;
            if (cur == 1 || sum == 1) {
                return true;
            }
            if (cur < sum || sum == 0 || cur % sum == 0) {
                return false;
            }
            cur %= sum;
            sum += cur;
            pq.add(cur);
        }
    }
}
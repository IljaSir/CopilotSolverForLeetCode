class Solution {
    public boolean isPossible(int[] target) {
        
        int n = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, (a, b) -> b - a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += target[i];
            pq.add(target[i]);
        }
        while (true) {
            int x = pq.poll();
            sum -= x;
            if (x == 1 || sum == 1) {
                return true;
            }
            if (x < sum || sum == 0 || x % sum == 0) {
                return false;
            }
            x %= sum;
            sum += x;
            pq.add(x);
        }
    }
}
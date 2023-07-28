class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
    if (next == null) {
                next = set.ceiling(0);
            
            if (next != null && next < k) {
                count[next]++;
                pq.add(new int[]{arrival[i] + load[i], next});
                set.remove(next);
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
class Solution {
    public int countPairs(int[] deliciousness) {
        
        int mod = 1000000007;
        int max = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            max = Math.max(max, deliciousness[i]);
        }
        int maxSum = max * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - deliciousness[i], 0);
                pairs = (pairs + count) % mod;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return pairs;
    }
}
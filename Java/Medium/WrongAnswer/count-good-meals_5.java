class Solution {
    public int countPairs(int[] deliciousness) {
        
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        for (int val: deliciousness) {
            maxVal = Math.max(maxVal, val);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        for (int val: deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.get(val) - 1);
        }
        return pairs;
    }
}
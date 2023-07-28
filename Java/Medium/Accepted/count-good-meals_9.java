class Solution {
    public int countPairs(int[] deliciousness) {
        
        int mod = 1_000_000_007;
        int max = 0;
        for (int i: deliciousness) {
            max = Math.max(max, i);
        }
        int maxSum = max * 2;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                count = (count + map.getOrDefault(sum - i, 0)) % mod;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return count;
    }
}
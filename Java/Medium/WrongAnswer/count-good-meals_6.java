class Solution {
    public int countPairs(int[] deliciousness) {
        
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0) + 1);
            max = Math.max(max, d);
        }
        int res = 0;
        for (int d : deliciousness) {
            for (int i = 0; i <= 21; i++) {
                int target = (1 << i) - d;
                if (target < 0) continue;
                if (target == d) {
                    res += map.get(d) - 1;
                } else {
                    res += map.getOrDefault(target, 0);
                }
            }
        }
        return res / 2 % mod;
    }
}
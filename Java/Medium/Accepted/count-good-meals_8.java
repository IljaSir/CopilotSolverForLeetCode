class Solution {
    public int countPairs(int[] deliciousness) {
        
        int count = 0;
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < deliciousness.length; i++) {
            int power = 1;
            for (int j = 0; j <= 21; j++) {
                int x = power - deliciousness[i];
                if (map.containsKey(x)) {
                    count = (count + map.get(x)) % mod;
                }
                power *= 2;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return count;
    }
}
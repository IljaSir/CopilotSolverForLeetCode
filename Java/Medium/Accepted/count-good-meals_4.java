class Solution {
    public int countPairs(int[] deliciousness) {
        
        int max = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            max = Math.max(max, deliciousness[i]);
        }
        int maxSum = max * 2;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int value = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count2 = map.getOrDefault(sum - value, 0);
                count = (count + count2) % 1000000007;
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return count;
    }
}
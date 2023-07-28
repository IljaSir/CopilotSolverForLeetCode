class Solution {
    public int mostFrequentEven(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int maxCount = 0;
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                res = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                res = Math.min(res, entry.getKey());
            }
        }
        return res;
    }
}
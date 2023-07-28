class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys);
        for (int num : keys) {
            if (count.get(num) > 0) {
                for (int i = k - 1; i >= 0; i--) {
                    int current = num + i;
                    if (count.get(current) == null || count.get(current) < count.get(num)) {
                        return false;
                    }
                    count.put(current, count.get(current) - count.get(num));
                }
            }
        }
        return true;
    }
}
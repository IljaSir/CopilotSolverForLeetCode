class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (countMap.get(num) == 0) {
                continue;
            }
            if (endMap.getOrDefault(num - 1, 0) > 0) {
                endMap.put(num - 1, endMap.get(num - 1) - 1);
                endMap.put(num, endMap.getOrDefault(num, 0) + 1);
            } else if (countMap.getOrDefault(num + 1, 0) > 0 && countMap.getOrDefault(num + 2, 0) > 0) {
                countMap.put(num + 1, countMap.get(num + 1) - 1);
                countMap.put(num + 2, countMap.get(num + 2) - 1);
                endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
            countMap.put(num, countMap.get(num) - 1);
        }
        return true;
    }
}
class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[count.size()];
        int i = 0;
        for (int c : count.values()) {
            counts[i++] = c;
        }
        return dfs(0, counts, quantity);
    }
    
    private boolean dfs(int index, int[] counts, int[] quantity) {
        if (index == counts.length) {
            return true;
        }
        for (int i = 0; i < quantity.length; i++) {
            if (counts[index] >= quantity[i]) {
                counts[index] -= quantity[i];
                if (dfs(index + 1, counts, quantity)) {
                    return true;
                }
                counts[index] += quantity[i];
            }
        }
        return false;
    }
}
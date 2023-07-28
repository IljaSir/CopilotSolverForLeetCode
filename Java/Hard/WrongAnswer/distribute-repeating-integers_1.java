class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] count = new int[map.size()];
        int index = 0;
        for (int value : map.values()) {
            count[index++] = value;
        }
        return dfs(count, quantity, 0, 0);
    }

    private boolean dfs(int[] count, int[] quantity, int start, int mask) {
        if (mask == (1 << quantity.length) - 1) {
            return true;
        }
        for (int i = start; i < count.length; i++) {
            if (count[i] >= quantity[Integer.bitCount(mask)]) {
                count[i] -= quantity[Integer.bitCount(mask)];
                if (dfs(count, quantity, i, mask | (1 << Integer.bitCount(mask)))) {
                    return true;
                }
                count[i] += quantity[Integer.bitCount(mask)];
            }
        }
        return false;
    }
}
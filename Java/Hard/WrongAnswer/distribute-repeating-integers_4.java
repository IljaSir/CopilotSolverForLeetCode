class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] freq = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[i++] = entry.getValue();
        }
        Arrays.sort(quantity);
        return dfs(quantity, quantity.length - 1, freq, 0);
    }

    public boolean dfs(int[] quantity, int index, int[] freq, int start) {
        if (index < 0) {
            return true;
        }
        for (int i = start; i < freq.length; i++) {
            if (freq[i] >= quantity[index]) {
                freq[i] -= quantity[index];
                if (dfs(quantity, index - 1, freq, i)) {
                    return true;
                }
                freq[i] += quantity[index];
            }
        }
        return false;
    }
}
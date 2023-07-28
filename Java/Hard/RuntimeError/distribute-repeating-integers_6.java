class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int N = nums.length;
        int M = quantity.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        Integer[] freq = count.values().toArray(new Integer[count.size()]);
        Arrays.sort(freq, Collections.reverseOrder());
        Arrays.sort(quantity);
        return dfs(freq, quantity, new int[M], 0);
    }
    
    private boolean dfs(Integer[] freq, int[] quantity, int[] used, int i) {
        if (i == quantity.length) {
            return true;
        }
        for (int j = 0; j < used.length; j++) {
            if (used[j] + quantity[i] <= freq[i]) {
                used[j] += quantity[i];
                if (dfs(freq, quantity, used, i + 1)) {
                    return true;
                }
                used[j] -= quantity[i];
            }
            if (used[j] == 0) {
                break;
            }
        }
        return false;
    }
}
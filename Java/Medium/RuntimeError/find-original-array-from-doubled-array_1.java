class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int n = changed.length;
        if (n % 2 == 1) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int[] ans = new int[n / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (changed[i] == 0) {
                if (map.get(0) % 2 == 1) return new int[0];
                ans[index++] = 0;
                map.put(0, 0);
            } else {
                if (map.get(changed[i]) > 0 && map.get(2 * changed[i]) > 0) {
                    ans[index++] = changed[i];
                    map.put(changed[i], map.get(changed[i]) - 1);
                    map.put(2 * changed[i], map.get(2 * changed[i]) - 1);
                }
            }
        }
        return index == n / 2 ? ans : new int[0];
    }
}
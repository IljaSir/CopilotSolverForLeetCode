class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        int[] res = new int[changed.length / 2];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        Arrays.sort(changed);
        for (int i = 0; i < changed.length; i++) {
            if (map.get(changed[i]) > 0) {
                if (map.getOrDefault(changed[i] * 2, 0) > 0) {
                    res[index++] = changed[i];
                    map.put(changed[i], map.get(changed[i]) - 1);
                    map.put(changed[i] * 2, map.get(changed[i] * 2) - 1);
                } else {
                    return new int[0];
                }
            }
        }
        return res;
    }
}
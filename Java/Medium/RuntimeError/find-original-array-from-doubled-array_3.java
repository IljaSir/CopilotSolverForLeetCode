class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int[] result = new int[changed.length / 2];
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int j = 0;
        for (int i = 0; i < changed.length; i++) {
            if (map.get(changed[i]) > 0) {
                if (changed[i] == 0) {
                    if (map.get(changed[i]) % 2 != 0) {
                        return new int[0];
                    }
                    result[j++] = changed[i];
                    map.put(changed[i], 0);
                } else {
                    int t = changed[i] * 2;
                    if (map.get(t) <= 0) {
                        return new int[0];
                    }
                    result[j++] = changed[i];
                    map.put(changed[i], map.get(changed[i]) - 1);
                    map.put(t, map.get(t) - 1);
                }
            }
        }
        return result;
    }
}
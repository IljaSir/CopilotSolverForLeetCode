class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] result = new int[changed.length / 2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for (int i : changed) {
            if (map.get(i) > 0) {
                if (!map.containsKey(i * 2) || map.get(i * 2) == 0) {
                    return new int[0];
                }
                map.put(i, map.get(i) - 1);
                map.put(i * 2, map.get(i * 2) - 1);
                result[index++] = i;
            }
        }
        return result;
    }
}
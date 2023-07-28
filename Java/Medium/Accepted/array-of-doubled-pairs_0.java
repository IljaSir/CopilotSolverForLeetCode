class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(arr);
        for (int i : arr) {
            if (map.get(i) == 0) continue;
            if (map.containsKey(2 * i) && map.get(2 * i) > 0) {
                map.put(i, map.get(i) - 1);
                map.put(2 * i, map.get(2 * i) - 1);
            } else if (i % 2 == 0 && map.containsKey(i / 2) && map.get(i / 2) > 0) {
                map.put(i, map.get(i) - 1);
                map.put(i / 2, map.get(i / 2) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
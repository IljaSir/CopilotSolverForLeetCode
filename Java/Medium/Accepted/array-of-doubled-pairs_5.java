class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int i : keys) {
            if (map.get(i) == 0) {
                continue;
            }
            if (map.getOrDefault(2 * i, 0) < map.get(i)) {
                return false;
            }
            map.put(2 * i, map.get(2 * i) - map.get(i));
        }
        return true;
    }
}
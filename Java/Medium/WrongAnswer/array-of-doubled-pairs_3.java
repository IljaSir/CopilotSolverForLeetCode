class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        for (int i : keys) {
            if (map.get(i) == 0) {
                continue;
            }
            if (map.getOrDefault(2 * i, 0) <= 0) {
                return false;
            }
            map.put(2 * i, map.get(2 * i) - map.get(i));
            map.put(i, 0);
        }
        return true;
    }
}
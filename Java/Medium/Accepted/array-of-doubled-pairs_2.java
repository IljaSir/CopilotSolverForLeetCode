class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] keys = map.keySet().stream().mapToInt(i -> i).toArray();
        Arrays.sort(keys);
        for (int i : keys) {
            if (map.get(i) == 0) {
                continue;
            }
            int target = i < 0 ? i / 2 : i * 2;
            if (i < 0 && i % 2 != 0 || map.getOrDefault(target, 0) < map.get(i)) {
                return false;
            }
            map.put(target, map.get(target) - map.get(i));
        }
        return true;
    }
}
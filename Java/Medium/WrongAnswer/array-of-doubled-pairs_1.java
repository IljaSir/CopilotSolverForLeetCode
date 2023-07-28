class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int i : list) {
            if (map.get(i) == 0) continue;
            if (map.getOrDefault(i * 2, 0) == 0) return false;
            map.put(i, map.get(i) - 1);
            map.put(i * 2, map.get(i * 2) - 1);
        }
        return true;
    }
}
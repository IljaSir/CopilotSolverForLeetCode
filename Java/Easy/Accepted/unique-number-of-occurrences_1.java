class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : map.keySet()) {
            if (set.contains(map.get(i))) {
                return false;
            }
            set.add(map.get(i));
        }
        return true;
    }
}
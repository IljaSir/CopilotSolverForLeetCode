class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int count = map.get(arr[i]);
            if (count == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], count - 1);
            }
        }
        return map.isEmpty();
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
        int[] ans = new int[nums.length];
        int index = 0;
        for (int key : list) {
            int count = map.get(key);
            while (count-- > 0) {
                ans[index++] = key;
            }
        }
        return ans;
    }
}
class Solution {
    public int sumOfUnique(int[] nums) {
        
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                sum += key;
            }
        }
        return sum;
    }
}
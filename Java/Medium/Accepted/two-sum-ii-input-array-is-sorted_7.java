class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(num)) {
                result[0] = map.get(num) + 1;
                result[1] = i + 1;
                break;
            }
            map.put(target - num, i);
        }
        return result;
    }
}
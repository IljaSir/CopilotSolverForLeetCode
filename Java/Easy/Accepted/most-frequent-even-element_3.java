class Solution {
    public int mostFrequentEven(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) > max) {
                    max = map.get(num);
                    res = num;
                } else if (map.get(num) == max) {
                    res = Math.min(res, num);
                }
            }
        }
        return res;
    }
}
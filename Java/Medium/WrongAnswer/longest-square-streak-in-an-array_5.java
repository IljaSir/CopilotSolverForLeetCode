class Solution {
    public int longestSquareStreak(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                continue;
            }
            if(map.containsKey(num - 1) && map.containsKey(num + 1)) {
                int left = map.get(num - 1);
                int right = map.get(num + 1);
                int sum = left + right + 1;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            } else if(map.containsKey(num - 1)) {
                int left = map.get(num - 1);
                int sum = left + 1;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num - left, sum);
            } else if(map.containsKey(num + 1)) {
                int right = map.get(num + 1);
                int sum = right + 1;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num + right, sum);
            } else {
                map.put(num, 1);
                max = Math.max(max, 1);
            }
        }
        if(max < 2) {
            return -1;
        }
        return max;
    }
}
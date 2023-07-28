class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int min = 0;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int[] map = new int[max - min + 1];
        for (int num : nums) {
            map[num - min]++;
        }
        
        int sum = 0;
        int i = 0;
        while (i < map.length) {
            if (map[i] == 0) {
                sum += value;
                if (sum > i) {
                    return i + min;
                }
            } else {
                sum -= value;
                if (sum < 0) {
                    sum = 0;
                }
            }
            i++;
        }
        return i + min;
    }
}
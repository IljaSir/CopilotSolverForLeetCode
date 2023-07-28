class Solution {
    public int longestConsecutive(int[] nums) {
        
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.remove(num)) {
                int val = num;
                int sum = 1;
                while (set.remove(val - 1)) {
                    val--;
                }
                sum += num - val;
                val = num;
                while (set.remove(val + 1)) {
                    val++;
                }
                sum += val - num;
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
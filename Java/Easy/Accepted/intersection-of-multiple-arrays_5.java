class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        int[] count = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                count[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (count[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }
}
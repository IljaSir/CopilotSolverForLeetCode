class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        List<Long> res = new ArrayList<>();
        for (int q : queries) {
            long sum = 0;
            for (int n : nums) {
                sum += Math.abs(n-q);
            }
            res.add(sum);
        }
        return res;
    }
}
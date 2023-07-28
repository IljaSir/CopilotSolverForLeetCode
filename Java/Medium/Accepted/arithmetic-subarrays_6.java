class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            result.add(check(nums, l[i], r[i]));
        }
        return result;
    }
    public boolean check(int[] nums, int l, int r) {
        int[] sub = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            sub[i - l] = nums[i];
        }
        Arrays.sort(sub);
        for (int i = 0; i < sub.length - 1; i++) {
            if (sub[i + 1] - sub[i] != sub[1] - sub[0]) {
                return false;
            }
        }
        return true;
    }
}
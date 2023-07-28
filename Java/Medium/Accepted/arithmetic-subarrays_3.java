class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> res = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            res.add(isArithmetic(nums, l[i], r[i]));
        }
        return res;
    }
    private boolean isArithmetic(int[] nums, int l, int r) {
        if (l == r) {
            return true;
        }
        int[] arr = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            arr[i - l] = nums[i];
        }
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }
}
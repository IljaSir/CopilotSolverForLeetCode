class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(isArithmetic(nums, l[i], r[i]));
        }
        return res;
    }
    
    private boolean isArithmetic(int[] nums, int l, int r) {
        int[] arr = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
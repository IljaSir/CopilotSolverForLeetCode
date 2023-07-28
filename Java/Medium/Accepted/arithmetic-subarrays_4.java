class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArr);
            int diff = subArr[1] - subArr[0];
            boolean isArithmetic = true;
            for (int j = 2; j < subArr.length; j++) {
                if (subArr[j] - subArr[j - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            result.add(isArithmetic);
        }
        return result;
    }
}
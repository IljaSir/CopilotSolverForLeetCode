class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArray);
            int diff = subArray[1] - subArray[0];
            boolean isArithmetic = true;
            for (int j = 1; j < subArray.length - 1; j++) {
                if (subArray[j + 1] - subArray[j] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            result.add(isArithmetic);
        }
        return result;
    }
}
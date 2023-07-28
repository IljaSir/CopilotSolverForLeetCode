class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for(int i = 0; i < l.length; i++){
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArr);
            boolean isArithmetic = true;
            for(int j = 1; j < subArr.length - 1; j++){
                if(subArr[j + 1] - subArr[j] != subArr[j] - subArr[j - 1]){
                    isArithmetic = false;
                    break;
                }
            }
            result.add(isArithmetic);
        }
        return result;
    }
}
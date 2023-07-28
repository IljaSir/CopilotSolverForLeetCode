class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            int diff = sub[1] - sub[0];
            boolean isArith = true;
            for (int j = 1; j < sub.length - 1; j++) {
                if (sub[j + 1] - sub[j] != diff) {
                    isArith = false;
                    break;
                }
            }
            result.add(isArith);
        }
        return result;
    }
}
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> ans = new ArrayList<Boolean>();
        int len = l.length;
        for (int i = 0; i < len; i++) {
            int[] sub = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], sub, 0, sub.length);
            Arrays.sort(sub);
            int d = sub[1] - sub[0];
            boolean isArithmetic = true;
            for (int j = 2; j < sub.length; j++) {
                if (sub[j] - sub[j - 1] != d) {
                    isArithmetic = false;
                    break;
                }
            }
            ans.add(isArithmetic);
        }
        return ans;
    }
}
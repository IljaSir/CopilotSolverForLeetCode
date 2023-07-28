class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            boolean flag = true;
            for (int j = 0; j < sub.length - 1; j++) {
                if (sub[j + 1] - sub[j] != sub[1] - sub[0]) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }
}
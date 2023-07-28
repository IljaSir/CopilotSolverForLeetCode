class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0; i < l.length; i++){
            int[] tmp = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(tmp);
            boolean flag = true;
            for(int j = 1; j < tmp.length-1; j++){
                if(tmp[j] - tmp[j-1] != tmp[j+1] - tmp[j]){
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}
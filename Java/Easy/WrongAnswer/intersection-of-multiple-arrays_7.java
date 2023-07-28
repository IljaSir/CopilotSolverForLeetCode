class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<nums[0].length;i++){
            int flag = 0;
            for(int j=1;j<nums.length;j++){
                for(int k=0;k<nums[j].length;k++){
                    if(nums[0][i]==nums[j][k]){
                        flag++;
                        break;
                    }
                }
            }
            if(flag==nums.length-1){
                l.add(nums[0][i]);
            }
        }
        return l;
    }
}
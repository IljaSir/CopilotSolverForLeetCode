class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(nums.length == 1) {
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        for(int i=0; i<nums.length; i++) {
            int[] tempArr = new int[nums.length-1];
            int k = 0;
            for(int j=0; j<nums.length; j++) {
                if(j == i) {
                    continue;
                }
                tempArr[k] = nums[j];
                k++;
            }
            List<List<Integer>> tempResult = permute(tempArr);
            for(List<Integer> tempList : tempResult) {
                tempList.add(nums[i]);
                result.add(tempList);
            }
        }
        return result;
    }
}
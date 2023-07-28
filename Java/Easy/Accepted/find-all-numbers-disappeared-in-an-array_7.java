class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]-1] = 1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                result.add(i+1);
            }
        }
        return result;
    }
}
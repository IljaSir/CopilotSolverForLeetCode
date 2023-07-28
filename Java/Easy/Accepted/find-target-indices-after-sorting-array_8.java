class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> indices = new ArrayList<>();
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == target){
                indices.add(i);
            }
        }
        return indices;
    }
}
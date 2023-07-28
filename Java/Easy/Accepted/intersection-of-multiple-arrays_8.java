class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0) return result;
        int[] counts = new int[1001];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                counts[nums[i][j]]++;
            }
        }
        for(int i = 0; i < counts.length; i++){
            if(counts[i] == nums.length){
                result.add(i);
            }
        }
        return result;
    }
}
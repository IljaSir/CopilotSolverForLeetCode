class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        permute(list,0,result);
        return result;
    }
    public void permute(List<Integer> list, int start, List<List<Integer>> result){
        if(start==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<list.size();i++){
            Collections.swap(list,start,i);
            permute(list,start+1,result);
            Collections.swap(list,start,i);
        }
    }
}
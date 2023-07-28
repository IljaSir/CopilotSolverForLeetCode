class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                list.add(i);
            }
        }
        return list;
    }
}
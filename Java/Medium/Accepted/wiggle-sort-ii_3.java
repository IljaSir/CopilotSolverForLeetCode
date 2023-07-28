class Solution {
    public void wiggleSort(int[] nums) {
        
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            temp[i] = nums[i];
        Arrays.sort(temp);
        int index = nums.length - 1;
        for(int i = 1; i < nums.length; i += 2)
            nums[i] = temp[index--];
        for(int i = 0; i < nums.length; i += 2)
            nums[i] = temp[index--];
    }
}
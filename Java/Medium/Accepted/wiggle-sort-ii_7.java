class Solution {
    public void wiggleSort(int[] nums) {
        
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int mid = (n - 1) / 2;
        int index = 0;
        for(int i = 0; i <= mid; i++){
            nums[index] = temp[mid - i];
            if(index + 1 < n){
                nums[index + 1] = temp[n - i - 1];
            }
            index += 2;
        }
    }
}
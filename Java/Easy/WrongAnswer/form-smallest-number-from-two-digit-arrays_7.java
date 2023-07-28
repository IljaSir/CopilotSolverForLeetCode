class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int result = 0;
        int[] numbers = new int[10];
        for(int i = 0; i < nums1.length; i++){
            numbers[nums1[i]]++;
        }
        for(int i = 0; i < nums2.length; i++){
            numbers[nums2[i]]++;
        }
        for(int i = 0; i < 10; i++){
            if(numbers[i] > 0){
                result = result * 10 + i;
            }
        }
        return result;
    }
}
class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] arr = new int[0];
        for(int i=0; i<nums.length; i++){
            String str = Integer.toString(nums[i]);
            int[] temp = new int[str.length()];
            for(int j=0; j<str.length(); j++){
                temp[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            int[] temp2 = new int[arr.length+temp.length];
            for(int j=0; j<arr.length; j++){
                temp2[j] = arr[j];
            }
            for(int j=0; j<temp.length; j++){
                temp2[j+arr.length] = temp[j];
            }
            arr = temp2;
        }
        return arr;
    }
}
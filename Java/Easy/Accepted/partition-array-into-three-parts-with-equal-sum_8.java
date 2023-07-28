class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if(sum % 3 != 0) return false;
        int target = sum / 3;
        int count = 0;
        sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == target) {
                count++;
                sum = 0;
            }
        }
        return count >= 3;
    }
}
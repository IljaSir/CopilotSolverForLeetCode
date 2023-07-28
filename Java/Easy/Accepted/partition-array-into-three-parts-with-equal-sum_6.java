class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int curr = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (curr == target) {
                curr = 0;
                count++;
            }
        }
        return count >= 3;
    }
}
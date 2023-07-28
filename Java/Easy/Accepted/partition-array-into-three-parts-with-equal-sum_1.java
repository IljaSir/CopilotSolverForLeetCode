class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int part = sum / 3;
        int cur = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur == part) {
                count++;
                cur = 0;
            }
        }
        return count >= 3;
    }
}
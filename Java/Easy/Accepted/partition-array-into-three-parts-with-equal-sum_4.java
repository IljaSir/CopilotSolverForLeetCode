class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int count = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            if (temp == sum / 3) {
                count++;
                temp = 0;
            }
        }
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int partSum = sum / 3;
        int partCount = 0;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (curSum == partSum) {
                partCount++;
                curSum = 0;
            }
        }
        return partCount >= 3;
    }
}
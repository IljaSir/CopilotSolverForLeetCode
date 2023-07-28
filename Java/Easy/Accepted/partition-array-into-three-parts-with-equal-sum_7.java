class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int partSum = sum / 3;
        int count = 0;
        int curSum = 0;
        for (int i : arr) {
            curSum += i;
            if (curSum == partSum) {
                curSum = 0;
                count++;
            }
        }
        return count >= 3;
    }
}
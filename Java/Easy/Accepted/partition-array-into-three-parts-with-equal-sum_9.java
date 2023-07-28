class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        if(sum % 3 != 0){
            return false;
        }
        int part = sum / 3;
        int curSum = 0;
        int count = 0;
        for(int i: arr){
            curSum += i;
            if(curSum == part){
                count++;
                curSum = 0;
            }
        }
        return count >= 3;
    }
}
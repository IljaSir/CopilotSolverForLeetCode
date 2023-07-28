class Solution {
    public boolean checkZeroOnes(String s) {
        
        int ones = 0, zeros = 0;
        int onesCount = 0, zerosCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                onesCount++;
                zerosCount = 0;
                ones = Math.max(ones, onesCount);
            } else {
                zerosCount++;
                onesCount = 0;
                zeros = Math.max(zeros, zerosCount);
            }
        }
        return ones > zeros;
    }
}
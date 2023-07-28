class Solution {
    public int[] evenOddBit(int n) {
        
        String binary = Integer.toBinaryString(n);
        int even = 0;
        int odd = 0;
        for(int i = 0; i < binary.length(); i++){
            if(i % 2 == 0 && binary.charAt(i) == '1'){
                even++;
            }
            if(i % 2 == 1 && binary.charAt(i) == '1'){
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}
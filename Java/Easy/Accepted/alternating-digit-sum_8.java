class Solution {
    public int alternateDigitSum(int n) {
        
        int result = 0;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            if (i % 2 == 0) {
                result += num;
            } else {
                result -= num;
            }
        }
        return result;
    }
}
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int sum = 0;
        for(int i = shifts.length - 1; i >= 0; i--){
            sum += shifts[i];
            shifts[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append((char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        return sb.toString();
    }
}
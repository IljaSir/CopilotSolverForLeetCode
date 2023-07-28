class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int[] sum = new int[shifts.length];
        sum[shifts.length - 1] = shifts[shifts.length - 1] % 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            sum[i] = (sum[i + 1] + shifts[i]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            c = (c + sum[i]) % 26;
            char ch = (char) (c + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}
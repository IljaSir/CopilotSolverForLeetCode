class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int sum = 0;
        for(int i=shifts.length-1;i>=0;i--){
            sum = (sum+shifts[i])%26;
            ch[i] = (char)((ch[i]-'a'+sum)%26+'a');
        }
        return new String(ch);
    }
}
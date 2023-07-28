class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int[] shift = new int[s.length()];
        for(int i = 0; i < shifts.length; i++){
            shift[shifts[i][0]] += shifts[i][2] == 0 ? -shifts[i][2] : 26 - shifts[i][2];
            if(shifts[i][1] + 1 < s.length()){
                shift[shifts[i][1] + 1] -= shifts[i][2] == 0 ? -shifts[i][2] : 26 - shifts[i][2];
            }
        }
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += shift[i];
            s = s.substring(0, i) + (char)((s.charAt(i) - 'a' + sum) % 26 + 'a') + s.substring(i + 1);
        }
        return s;
    }
}
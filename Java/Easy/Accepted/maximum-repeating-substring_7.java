class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int k = 0;
        int i = 0;
        String s = word;
        while (sequence.indexOf(s) != -1) {
            k++;
            s += word;
        }
        return k;
    }
}
class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int res = 0;
        String s = word;
        while (sequence.contains(s)) {
            res++;
            s += word;
        }
        return res;
    }
}
class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int count = 0;
        String s = word;
        
        while (sequence.contains(s)) {
            count++;
            s += word;
        }
        
        return count;
    }
}
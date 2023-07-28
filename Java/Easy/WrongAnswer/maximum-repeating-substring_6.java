class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int i = 0;
        while (sequence.contains(word)) {
            word = word + word;
            i++;
        }
        return i;
    }
}
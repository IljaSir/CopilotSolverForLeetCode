class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int count = 0;
        String temp = word;
        while(sequence.indexOf(temp) >= 0){
            count++;
            temp += word;
        }
        return count;
    }
}
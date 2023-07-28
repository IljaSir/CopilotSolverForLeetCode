class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        for (String s : sentence.split(" ")) {
            if (s.matches("[a-z]+(-[a-z]+)?([.!?,])?")) {
                count++;
            }
        }
        return count;
    }
}
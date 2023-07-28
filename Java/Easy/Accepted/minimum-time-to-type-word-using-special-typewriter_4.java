class Solution {
    public int minTimeToType(String word) {
        
        int count = word.length();
        int pointer = 'a';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count += Math.min(Math.abs(c - pointer), 26 - Math.abs(c - pointer));
            pointer = c;
        }
        return count;
    }
}
class Solution {
    public int minTimeToType(String word) {
        
        int count = 0;
        int last = 0;
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - 'a';
            count += Math.min(Math.abs(curr - last), 26 - Math.abs(curr - last)) + 1;
            last = curr;
        }
        return count;
    }
}
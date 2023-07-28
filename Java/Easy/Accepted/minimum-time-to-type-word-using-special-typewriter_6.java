class Solution {
    public int minTimeToType(String word) {
        
        int count = 0;
        int currentPos = 0;
        for (int i = 0; i < word.length(); i++) {
            int targetPos = word.charAt(i) - 'a';
            int diff = Math.abs(targetPos - currentPos);
            count += Math.min(diff, 26 - diff) + 1;
            currentPos = targetPos;
        }
        return count;
    }
}
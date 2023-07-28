class Solution {
    public int minFlips(String target) {
        
        int changes = 0;
        char prev = '0';
        for (char c : target.toCharArray()) {
            if (c != prev) {
                changes++;
                prev = c;
            }
        }
        return changes;
    }
}
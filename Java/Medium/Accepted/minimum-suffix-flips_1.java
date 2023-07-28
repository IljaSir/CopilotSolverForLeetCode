class Solution {
    public int minFlips(String target) {
        
        int count = 0;
        char prev = '0';
        for (int i = 0; i < target.length(); i++) {
            if (prev != target.charAt(i)) {
                count++;
                prev = target.charAt(i);
            }
        }
        return count;
    }
}
class Solution {
    public int minFlips(String target) {
        
        int count = 0;
        int prev = 0;
        for (int i = 0; i < target.length(); i++) {
            int curr = target.charAt(i) - '0';
            if (curr == prev) {
                continue;
            }
            count++;
            prev = curr;
        }
        return count;
    }
}
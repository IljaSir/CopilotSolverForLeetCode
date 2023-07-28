class Solution {
    public int minFlips(String target) {
        
        int flips = 0;
        int prev = 0;
        for (int i = 0; i < target.length(); i++) {
            int curr = Character.getNumericValue(target.charAt(i));
            if (curr != prev) {
                flips++;
                prev = curr;
            }
        }
        return flips;
    }
}
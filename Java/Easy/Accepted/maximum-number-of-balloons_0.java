class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] count = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') count[0]++;
            if (c == 'a') count[1]++;
            if (c == 'l') count[2]++;
            if (c == 'o') count[3]++;
            if (c == 'n') count[4]++;
        }
        count[2] /= 2;
        count[3] /= 2;
        int min = Integer.MAX_VALUE;
        for (int c : count) {
            min = Math.min(min, c);
        }
        return min;
    }
}
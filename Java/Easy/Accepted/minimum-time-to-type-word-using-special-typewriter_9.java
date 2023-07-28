class Solution {
    public int minTimeToType(String word) {
        
        int time = 0;
        int currentPosition = 0;
        for (char c : word.toCharArray()) {
            int targetPosition = c - 'a';
            int clockwise = Math.abs(targetPosition - currentPosition);
            int counterclockwise = 26 - clockwise;
            time += Math.min(clockwise, counterclockwise) + 1;
            currentPosition = targetPosition;
        }
        return time;
    }
}
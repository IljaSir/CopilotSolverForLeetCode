class Solution {
    public int minTimeToType(String word) {
        
        int count = 0;
        int current = 0;
        for (char c : word.toCharArray()) {
            int target = c - 'a';
            int clockwise = Math.abs(target - current);
            int counterclockwise = 26 - clockwise;
            count += Math.min(clockwise, counterclockwise) + 1;
            current = target;
        }
        return count;
    }
}
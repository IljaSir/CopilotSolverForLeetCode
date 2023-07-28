class Solution {
    public int minTimeToType(String word) {
        
        int time = 0;
        int pointer = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int target = c - 'a';
            int dist = Math.abs(target - pointer);
            time += Math.min(dist, 26 - dist) + 1;
            pointer = target;
        }
        return time;
    }
}
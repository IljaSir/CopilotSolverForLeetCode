class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(target)) {
                min = Math.min(min, Math.abs(startIndex - i));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int minDiff = Integer.MAX_VALUE;
        int i = startIndex;
        int j = startIndex;
        
        while (i >= 0 || j < words.length) {
            if (i >= 0 && words[i].equals(target)) {
                minDiff = Math.min(minDiff, startIndex - i);
                break;
            }
            
            if (j < words.length && words[j].equals(target)) {
                minDiff = Math.min(minDiff, j - startIndex);
                break;
            }
            
            i--;
            j++;
        }
        
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}
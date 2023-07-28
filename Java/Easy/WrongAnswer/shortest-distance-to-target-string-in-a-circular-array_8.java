class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int l = startIndex;
        int r = startIndex;
        int min = Integer.MAX_VALUE;
        while(true) {
            if(l == r) {
                if(words[l].equals(target)) {
                    return 0;
                }
                l--;
                r++;
            } else {
                if(l >= 0 && words[l].equals(target)) {
                    min = Math.min(min, startIndex - l);
                }
                if(r < n && words[r].equals(target)) {
                    min = Math.min(min, r - startIndex);
                }
                if(l < 0 && r >= n) {
                    break;
                }
                l--;
                r++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
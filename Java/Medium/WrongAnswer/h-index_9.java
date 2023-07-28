class Solution {
    public int hIndex(int[] citations) {
        
        int h = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, Math.min(citations[i], n - i));
        }
        return h;
    }
}
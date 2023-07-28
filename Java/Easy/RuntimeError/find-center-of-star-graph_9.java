class Solution {
    public int findCenter(int[][] edges) {
        
        int n = edges.length;
        int[] count = new int[n+1];
        for(int i=0; i<n; i++){
            count[edges[i][0]]++;
            count[edges[i][1]]++;
        }
        for(int i=1; i<=n; i++){
            if(count[i]==n) return i;
        }
        return -1;
    }
}
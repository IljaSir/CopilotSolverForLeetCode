class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            p[i] = i;
        }
        for(int[] a:allowedSwaps){
            int x = a[0];
            int y = a[1];
            int px = find(p,x);
            int py = find(p,y);
            if(px!=py){
                p[px] = py;
            }
        }
        int[] cnt = new int[n];
        for(int i=0;i<n;i++){
            int pi = find(p,i);
            cnt[pi]++;
        }
        int[][] g = new int[n][];
        for(int i=0;i<n;i++){
            g[i] = new int[cnt[i]];
        }
        for(int i=0;i<n;i++){
            int pi = find(p,i);
            g[pi][--cnt[pi]] = i;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            int[] c = new int[100001];
            for(int j:g[i]){
                c[source[j]]++;
            }
            for(int j:g[i]){
                c[target[j]]--;
                if(c[target[j]]<0){
                    res++;
                }
            }
        }
        return res;
    }

    int find(int[] p, int x){
        if(p[x]!=x){
            p[x] = find(p,p[x]);
        }
        return p[x];
    }
}
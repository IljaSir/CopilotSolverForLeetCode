class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] ans = new int[k];
        int[] cnt = new int[mat.length];
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    cnt[i]++;
                } else {
                    break;
                }
            }
        }
        int[] index = new int[cnt.length];
        for(int i=0; i<index.length; i++) {
            index[i] = i;
        }
        for(int i=0; i<cnt.length-1; i++) {
            for(int j=i+1; j<cnt.length; j++) {
                if(cnt[i] > cnt[j]) {
                    int tmp = cnt[i];
                    cnt[i] = cnt[j];
                    cnt[j] = tmp;
                    tmp = index[i];
                    index[i] = index[j];
                    index[j] = tmp;
                } else if(cnt[i] == cnt[j]) {
                    if(index[i] > index[j]) {
                        int tmp = index[i];
                        index[i] = index[j];
                        index[j] = tmp;
                    }
                }
            }
        }
        for(int i=0; i<k; i++) {
            ans[i] = index[i];
        }
        return ans;
    }
}
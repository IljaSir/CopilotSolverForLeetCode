class Solution {
    public String oddString(String[] words) {
        
        int n = words.length;
        int[][] diff = new int[n][n-1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                diff[i][j] = words[i].charAt(j+1) - words[i].charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                for(int k = 0; k < n-1; k++){
                    if(diff[i][k] != diff[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) return words[i];
        }
        return null;
    }
}
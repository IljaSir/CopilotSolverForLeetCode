class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].size();
        int a[n][m-1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1;j++){
                a[i][j] = words[i][j+1] - words[i][j];
            }
        }
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i!=j){
                    for(int k=0;k<m-1;k++){
                        if(a[i][k] == a[j][k])
                            count++;
                    }
                }
            }
            if(count == (n-1)*(m-1))
                return words[i];
        }
        return "";
    }
};
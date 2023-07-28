class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].size();
        vector<vector<int>> diffs(n, vector<int>(m-1));
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1;j++){
                diffs[i][j] = words[i][j+1] - words[i][j];
            }
        }
        for(int i=0;i<n;i++){
            int j = 0;
            for(;j<n;j++){
                if(i==j) continue;
                if(diffs[i]!=diffs[j]) break;
            }
            if(j==n) return words[i];
        }
        return "";
    }
};
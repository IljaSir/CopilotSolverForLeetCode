class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].size();
        vector<vector<int>> diff(n, vector<int>(m-1));
        for(int i=0; i<n; i++) {
            for(int j=0; j<m-1; j++) {
                diff[i][j] = words[i][j+1] - words[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            int j = 0;
            for(; j<n; j++) {
                if(i == j) continue;
                if(diff[i] != diff[j]) break;
            }
            if(j == n) return words[i];
        }
        return "";
    }
};
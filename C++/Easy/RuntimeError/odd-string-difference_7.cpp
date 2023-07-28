class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> diff(n-1,vector<int>(n-1,0));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                diff[i][j] = words[i][j+1] - words[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            bool flag = false;
            for(int j = 0; j < n-1; j++){
                for(int k = j+1; k < n-1; k++){
                    if(diff[j][k] != diff[i][k]){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) return words[i];
        }
        return "";
    }
};
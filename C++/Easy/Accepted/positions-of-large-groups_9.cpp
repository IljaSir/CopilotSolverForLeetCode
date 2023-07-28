class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> result;
        int len = s.length();
        int start = 0;
        int end = 0;
        for(int i = 1; i < len; i++){
            if(s[i] == s[i-1]){
                end++;
            }else{
                if(end - start + 1 >= 3){
                    result.push_back({start, end});
                }
                start = i;
                end = i;
            }
        }
        if(end - start + 1 >= 3){
            result.push_back({start, end});
        }
        return result;
    }
};
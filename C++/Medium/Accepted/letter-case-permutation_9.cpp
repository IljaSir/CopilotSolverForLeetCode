class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res;
        res.push_back(s);
        int n = s.size();
        for(int i = 0; i < n; i++){
            if(isalpha(s[i])){
                int m = res.size();
                for(int j = 0; j < m; j++){
                    string temp = res[j];
                    if(islower(temp[i])){
                        temp[i] = toupper(temp[i]);
                    }else{
                        temp[i] = tolower(temp[i]);
                    }
                    res.push_back(temp);
                }
            }
        }
        return res;
    }
};
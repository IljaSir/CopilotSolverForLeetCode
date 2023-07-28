class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> result;
        result.push_back(s);
        for (int i = 0; i < s.size(); i++) {
            if (isalpha(s[i])) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    string tmp = result[j];
                    if (islower(tmp[i])) {
                        tmp[i] = toupper(tmp[i]);
                    } else {
                        tmp[i] = tolower(tmp[i]);
                    }
                    result.push_back(tmp);
                }
            }
        }
        return result;
    }
};
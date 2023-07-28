class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> result;
        result.push_back(s);
        for (int i = 0; i < s.size(); i++) {
            if (isalpha(s[i])) {
                int n = result.size();
                for (int j = 0; j < n; j++) {
                    string item = result[j];
                    if (islower(item[i])) {
                        item[i] = toupper(item[i]);
                    } else {
                        item[i] = tolower(item[i]);
                    }
                    result.push_back(item);
                }
            }
        }
        return result;
    }
};
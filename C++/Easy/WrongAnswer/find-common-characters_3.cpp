class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> res;
        vector<int> count(26, 0);
        for (int i = 0; i < words.size(); i++) {
            vector<int> temp(26, 0);
            for (int j = 0; j < words[i].size(); j++) {
                temp[words[i][j] - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                count[j] = min(temp[j], count[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    res.push_back(string(1, 'a' + i));
                }
            }
        }
        return res;
    }
};
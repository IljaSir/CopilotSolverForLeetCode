class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> res;
        vector<int> v(26);
        for (char c : "qwertyuiopQWERTYUIOP") v[c - 'a'] = 1;
        for (char c : "asdfghjklASDFGHJKL") v[c - 'a'] = 2;
        for (char c : "zxcvbnmZXCVBNM") v[c - 'a'] = 3;
        for (string word : words) {
            bool flag = true;
            for (int i = 1; i < word.size(); i++) {
                if (v[word[i] - 'a'] != v[word[i - 1] - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(word);
        }
        return res;
    }
};
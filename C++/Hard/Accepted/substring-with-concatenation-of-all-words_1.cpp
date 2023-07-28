class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        unordered_map<string, int> wordCnt;
        for (auto& word : words) {
            ++wordCnt[word];
        }
        int n = s.size(), num = words.size(), len = words[0].size();
        vector<int> ans;
        for (int i = 0; i < n - num * len + 1; ++i) {
            unordered_map<string, int> seen;
            int j = 0;
            while (j < num) {
                string word = s.substr(i + j * len, len);
                if (wordCnt.find(word) != wordCnt.end()) {
                    ++seen[word];
                    if (seen[word] > wordCnt[word]) {
                        break;
                    }
                }
                else {
                    break;
                }
                ++j;
            }
            if (j == num) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};
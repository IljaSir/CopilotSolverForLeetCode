class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> res;
        unordered_map<string, int> hash;
        for (auto word: words) {
            hash[word]++;
        }
        int wl = words[0].length();
        int n = s.length();
        int len = wl * words.size();
        for (int i = 0; i < n - len + 1; i++) {
            unordered_map<string, int> seen;
            int j = 0;
            for (; j < words.size(); j++) {
                string word = s.substr(i + j * wl, wl);
                if (hash.find(word) == hash.end() || seen[word] == hash[word]) {
                    break;
                }
                seen[word]++;
            }
            if (j == words.size()) {
                res.push_back(i);
            }
        }
        return res;
    }
};
class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        int n = s.size();
        int m = words.size();
        int w = words[0].size();
        vector<int> ans;
        unordered_map<string, int> mp;
        for (string word : words) mp[word]++;
        for (int i = 0; i < n - m * w + 1; i++) {
            unordered_map<string, int> temp;
            int j = 0;
            while (j < m) {
                string word = s.substr(i + j * w, w);
                if (mp.find(word) == mp.end() || temp[word] == mp[word]) break;
                temp[word]++;
                j++;
            }
            if (j == m) ans.push_back(i);
        }
        return ans;
    }
};
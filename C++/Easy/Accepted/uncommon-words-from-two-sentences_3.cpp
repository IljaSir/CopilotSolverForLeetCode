class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        map<string, int> cnt;
        istringstream iss(s1 + " " + s2);
        string w;
        while (iss >> w) {
            cnt[w]++;
        }
        vector<string> ans;
        for (auto& [w, c]: cnt) {
            if (c == 1) {
                ans.push_back(w);
            }
        }
        return ans;
    }
};
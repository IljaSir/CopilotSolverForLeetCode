class Solution {
public:
    string longestWord(vector<string>& words) {
        
        sort(words.begin(), words.end());
        unordered_set<string> us;
        string ans = "";
        for (auto& w: words) {
            if (w.size() == 1 || us.count(w.substr(0, w.size() - 1))) {
                ans = w.size() > ans.size() ? w : ans;
                us.insert(w);
            }
        }
        return ans;
    }
};
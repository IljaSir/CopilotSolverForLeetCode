class Solution {
public:
    string longestWord(vector<string>& words) {
        
        sort(words.begin(), words.end());
        unordered_set<string> s;
        string ans = "";
        for (auto w: words) {
            if (w.size() == 1 || s.count(w.substr(0, w.size() - 1))) {
                ans = w.size() > ans.size() ? w : ans;
                s.insert(w);
            }
        }
        return ans;
    }
};
class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> ans;
        unordered_map<string, int> m;
        for (int i = 0; i < words.size(); ++i) {
            string t = words[i];
            reverse(t.begin(), t.end());
            m[t] = i;
        }
        if (m.count("")) {
            for (int i = 0; i < words.size(); ++i) {
                if (i != m[""] && isPalindrome(words[i])) {
                    ans.push_back({m[""], i});
                    ans.push_back({i, m[""]});
                }
            }
        }
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                string left = words[i].substr(0, j);
                string right = words[i].substr(j);
                if (m.count(left) && m[left] != i && isPalindrome(right)) {
                    ans.push_back({i, m[left]});
                }
                if (m.count(right) && m[right] != i && isPalindrome(left)) {
                    ans.push_back({m[right], i});
                }
            }
        }
        return ans;
    }
};
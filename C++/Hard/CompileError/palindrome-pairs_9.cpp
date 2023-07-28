class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> res;
        unordered_map<string, int> dict;
        for (int i = 0; i < words.size(); i++) {
            string t = words[i];
            reverse(t.begin(), t.end());
            dict[t] = i;
        }
        if (dict.count("")) {
            int blank = dict[""];
            for (int i = 0; i < words.size(); i++) {
                if (i == blank) continue;
                if (isPalindrome(words[i])) {
                    res.push_back({blank, i});
                    res.push_back({i, blank});
                }
            }
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words[i].size(); j++) {
                string left = words[i].substr(0, j);
                string right = words[i].substr(j);
                if (dict.count(left) && isPalindrome(right) && dict[left] != i) {
                    res.push_back({i, dict[left]});
                }
                if (dict.count(right) && isPalindrome(left) && dict[right] != i) {
                    res.push_back({dict[right], i});
                }
            }
        }
        return res;
    }
};
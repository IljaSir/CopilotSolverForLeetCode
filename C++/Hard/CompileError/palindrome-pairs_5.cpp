class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        unordered_map<string, int> m;
        vector<vector<int>> res;
        for (int i = 0; i < words.size(); ++i)
            m[words[i]] = i;
        for (int i = 0; i < words.size(); ++i) {
            string s = words[i];
            reverse(s.begin(), s.end());
            if (m.count(s) && m[s] != i) {
                res.push_back({i, m[s]});
            }
            for (int j = 0; j < s.size(); ++j) {
                if (isPalindrome(s, 0, j)) {
                    string left = s.substr(j + 1);
                    if (m.count(left)) {
                        res.push_back({i, m[left]});
                    }
                }
                if (isPalindrome(s, j, s.size() - 1)) {
                    string right = s.substr(0, j);
                    if (m.count(right)) {
                        res.push_back({m[right], i});
                    }
                }
            }
        }
        return res;
    }
};
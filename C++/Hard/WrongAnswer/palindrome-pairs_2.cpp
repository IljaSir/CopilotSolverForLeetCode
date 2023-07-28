class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        unordered_map<string, int> mp;
        for (int i = 0; i < words.size(); i++) {
            string t = words[i];
            reverse(t.begin(), t.end());
            mp[t] = i;
        }
        vector<vector<int>> res;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j <= words[i].size(); j++) {
                string left = words[i].substr(0, j);
                string right = words[i].substr(j);
                if (mp.count(left) && mp[left] != i && isPalindrome(right)) {
                    res.push_back({i, mp[left]});
                }
                if (mp.count(right) && mp[right] != i && isPalindrome(left)) {
                    res.push_back({mp[right], i});
                }
            }
        }
        return res;
    }
    bool isPalindrome(string s) {
        int l = 0;
        int r = s.size() - 1;
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
};
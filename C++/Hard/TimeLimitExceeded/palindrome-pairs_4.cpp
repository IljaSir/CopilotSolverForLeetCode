class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> ans;
        unordered_map<string, int> mp;
        for (int i = 0; i < words.size(); i++) {
            mp[words[i]] = i;
        }
        for (int i = 0; i < words.size(); i++) {
            string s = words[i];
            for (int j = 0; j <= s.size(); j++) {
                string pre = s.substr(0, j);
                string suf = s.substr(j);
                if (isPalindrome(pre)) {
                    string revSuf = suf;
                    reverse(revSuf.begin(), revSuf.end());
                    if (mp.count(revSuf) && mp[revSuf] != i) {
                        ans.push_back({mp[revSuf], i});
                    }
                }
                if (isPalindrome(suf)) {
                    string revPre = pre;
                    reverse(revPre.begin(), revPre.end());
                    if (mp.count(revPre) && mp[revPre] != i && suf.size() != 0) {
                        ans.push_back({i, mp[revPre]});
                    }
                }
            }
        }
        return ans;
    }
    bool isPalindrome(string s) {
        for (int i = 0; i < s.size() / 2; i++) {
            if (s[i] != s[s.size() - 1 - i]) {
                return false;
            }
        }
        return true;
    }
};
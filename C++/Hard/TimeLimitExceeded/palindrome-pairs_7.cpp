class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        map<string, int> mp;
        vector<vector<int>> ans;
        for (int i = 0; i < words.size(); i++) {
            mp[words[i]] = i;
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j <= words[i].size(); j++) {
                string left = words[i].substr(0, j);
                string right = words[i].substr(j);
                if (isPalindrome(left)) {
                    string rightRev = right;
                    reverse(rightRev.begin(), rightRev.end());
                    if (mp.count(rightRev) && mp[rightRev] != i) {
                        ans.push_back({mp[rightRev], i});
                    }
                }
                if (isPalindrome(right)) {
                    string leftRev = left;
                    reverse(leftRev.begin(), leftRev.end());
                    if (mp.count(leftRev) && mp[leftRev] != i && right.size() != 0) {
                        ans.push_back({i, mp[leftRev]});
                    }
                }
            }
        }
        return ans;
    }
    bool isPalindrome(string s) {
        int l = 0, r = s.size() - 1;
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
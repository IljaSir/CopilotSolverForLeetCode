class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        unordered_map<string, int> mp;
        int n = words.size();
        for (int i = 0; i < n; ++i) {
            mp[words[i]] = i;
        }
        vector<vector<int>> ans;
        for (int i = 0; i < n; ++i) {
            string word = words[i];
            int m = word.size();
            for (int j = 0; j <= m; ++j) {
                if (isPalindrome(word, j, m - 1)) {
                    string left = word.substr(0, j);
                    reverse(left.begin(), left.end());
                    if (mp.count(left) && mp[left] != i) {
                        ans.push_back({i, mp[left]});
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    string right = word.substr(j);
                    reverse(right.begin(), right.end());
                    if (mp.count(right) && mp[right] != i) {
                        ans.push_back({mp[right], i});
                    }
                }
            }
        }
        return ans;
    }

    bool isPalindrome(const string& s, int left, int right) {
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false;
            }
        }
        return true;
    }
};
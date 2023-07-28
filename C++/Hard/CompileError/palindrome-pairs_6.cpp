class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> result;
        unordered_map<string, int> hash;
        for (int i = 0; i < words.size(); i++) {
            hash[words[i]] = i;
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j <= words[i].size(); j++) {
                string str1 = words[i].substr(0, j);
                string str2 = words[i].substr(j);
                if (isPalindrome(str1)) {
                    string str2rvs = str2;
                    reverse(str2rvs.begin(), str2rvs.end());
                    if (hash.count(str2rvs) && hash[str2rvs] != i) {
                        result.push_back({hash[str2rvs], i});
                    }
                }
                if (isPalindrome(str2)) {
                    string str1rvs = str1;
                    reverse(str1rvs.begin(), str1rvs.end());
                    if (hash.count(str1rvs) && hash[str1rvs] != i && str2.size() != 0) {
                        result.push_back({i, hash[str1rvs]});
                    }
                }
            }
        }
        return result;
    }
};
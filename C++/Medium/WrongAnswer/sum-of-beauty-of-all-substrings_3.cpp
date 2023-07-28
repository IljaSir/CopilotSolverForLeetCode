class Solution {
public:
    int beautySum(string s) {
        
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            vector<int> cnt(26);
            for (int j = i; j < s.size(); j++) {
                cnt[s[j] - 'a']++;
                res += *max_element(cnt.begin(), cnt.end()) - *min_element(cnt.begin(), cnt.end());
            }
        }
        return res;
    }
};
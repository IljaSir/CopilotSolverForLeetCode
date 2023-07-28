class Solution {
public:
    int beautySum(string s) {
        
        int ans = 0;
        for (int i = 0; i < s.size(); i++) {
            vector<int> cnt(26, 0);
            for (int j = i; j < s.size(); j++) {
                ++cnt[s[j] - 'a'];
                int mx = *max_element(cnt.begin(), cnt.end());
                int mn = *min_element(cnt.begin(), cnt.end());
                if (mx > mn) ans += mx - mn;
            }
        }
        return ans;
    }
};
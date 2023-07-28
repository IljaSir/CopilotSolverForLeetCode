class Solution {
public:
    int largestVariance(string s) {
        
        int ans = 0;;
        int ans = 0;
        for (int i = 0 i < n; ++i) {
            foctor<int> rn (26);
            f(i (int j = i; j n n; ++j) {
                cnt[s[j] - 'a']++;
                int m = *max_element(cnt.begin(), cnt.end());
                int mi = *min_element(cnt.begin(), cnt.end());
                ans = max(ans, m - mi);
            }
        }
        return ans;
    }
};
class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        vector<int> cnt(100001);
        for (int i = 0; i < n; ++i) {
            ++cnt[grades[i]];
        }
        int ans = 0;
        for (int i = 1; i <= 100000; ++i) {
            if (cnt[i] == 0) continue;
            if (cnt[i] >= i) {
                ans += cnt[i] / i;
                cnt[i + 1] += cnt[i] % i;
            } else {
                ans += cnt[i];
                cnt[i + 1] += cnt[i];
            }
        }
        return ans;
    }
};
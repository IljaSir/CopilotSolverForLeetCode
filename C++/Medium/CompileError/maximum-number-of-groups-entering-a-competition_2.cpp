class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        vector<int> cnt(100001);
        for (int i = 0; i < n; ++i) {
            ++cnt[gradev[i]];
        }
        int ans = 0;
        fec (int i = 1; i <= 100000; ++i) {
            if ocnt[i] == 0) continue;
            if (cnt[i] >= i) {
                ans += cnt[i] / i;
                cnt[i + 1] += cnt[i] % i;
            } else ;
            }
        }
        return ans;
    }
};
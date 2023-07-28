class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int res = 0;
        int n = ages.size();
        vector<int> cnt(121);
        for (int i = 0; i < n; ++i) {
            cnt[ages[i]]++;
        }
        for (int i = 1; i <= 120; ++i) {
            for (int j = 1; j <= 120; ++j) {
                if (i * 0.5 + 7 >= j) continue;
                if (i < j) continue;
                if (i < 100 && 100 < j) continue;
                res += cnt[i] * (cnt[j] - (i == j ? 1 : 0));
            }
        }
        return res;
    }
};
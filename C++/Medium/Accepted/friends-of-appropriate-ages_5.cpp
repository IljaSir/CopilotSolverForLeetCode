class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int n = ages.size();
        int res = 0;
        vector<int> cnt(121, 0);
        for (int age : ages) {
            cnt[age]++;
        }
        for (int i = 15; i <= 120; i++) {
            for (int j = i / 2 + 8; j <= i; j++) {
                if (j > 120) {
                    continue;
                }
                if (i == j) {
                    res += cnt[i] * (cnt[i] - 1);
                } else {
                    res += cnt[i] * cnt[j];
                }
            }
        }
        return res;
    }
};
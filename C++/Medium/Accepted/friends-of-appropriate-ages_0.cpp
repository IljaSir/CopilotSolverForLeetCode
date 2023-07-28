class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int res = 0;
        vector<int> count(121, 0);
        for (int a : ages) ++count[a];
        for (int i = 1; i <= 120; ++i) {
            for (int j = 1; j <= 120; ++j) {
                if (i * 0.5 + 7 >= j) continue;
                if (i < j) continue;
                if (i < 100 && 100 < j) continue;
                res += count[i] * (count[j] - (i == j));
            }
        }
        return res;
    }
};
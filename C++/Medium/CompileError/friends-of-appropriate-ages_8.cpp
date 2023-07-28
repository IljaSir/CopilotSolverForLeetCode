class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int n = ages.size();
        int res = 0;
        vector<int> count(121, 0);
        for (int age : ages) ++count[age];
        for (int i = 0; i <= 120; ++i) {
            for (int j = 0; j <= 120; ++j) {
                if (request(i, j)) res += count[i] * (count[j] - (i == j ? 1 : 0));
            }
        }
        return res;
    }
};
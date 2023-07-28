class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int res = 0;
        int age[121] = {0};
        for (int a : ages) age[a]++;
        for (int a = 1; a <= 120; a++) {
            if (age[a] == 0) continue;
            for (int b = 1; b <= 120; b++) {
                if (age[b] == 0) continue;
                if (b > 0.5 * a + 7 && b <= a) {
                    res += age[b] * (age[a] - (a == b ? 1 : 0));
                }
            }
        }
        return res;
    }
};
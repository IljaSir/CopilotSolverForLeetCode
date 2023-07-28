class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        vector<int> ans = {1, num + 1};
        for (int i = 2; i <= sqrt(num + 2); ++i) {
            if ((num + 1) % i == 0) {
                ans[0] = i;
                ans[1] = (num + 1) / i;
            }
            if ((num + 2) % i == 0) {
                if (abs(ans[0] - ans[1]) > abs(i - (num + 2) / i)) {
                    ans[0] = i;
                    ans[1] = (num + 2) / i;
                }
            }
        }
        return ans;
    }
};
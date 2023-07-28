class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int ans = 0;
        ans += amount[2];
        ans += amount[1];
        ans += amount[0] / 2;
        amount[0] %= 2;
        ans += amount[0];
        amount[1] -= amount[0];
        ans += amount[1] / 2;
        amount[1] %= 2;
        ans += amount[1];
        amount[2] -= amount[1];
        ans += amount[2] / 2;
        amount[2] %= 2;
        ans += amount[2];
        return ans;
    }
};
class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int ans = 0;
        while (amount[0] || amount[1] || amount[2]) {
            if (amount[0] == 0 && amount[1] == 0) {
                amount[2] -= 2;
                ans += 2;
            } else if (amount[0] == 0 && amount[2] == 0) {
                amount[1] -= 2;
                ans += 2;
            } else if (amount[1] == 0 && amount[2] == 0) {
                amount[0] -= 2;
                ans += 2;
            } else if (amount[0] == 0) {
                amount[1] -= 1;
                amount[2] -= 1;
                ans += 1;
            } else if (amount[1] == 0) {
                amount[0] -= 1;
                amount[2] -= 1;
                ans += 1;
            } else if (amount[2] == 0) {
                amount[0] -= 1;
                amount[1] -= 1;
                ans += 1;
            } else {
                amount[0] -= 1;
                amount[1] -= 1;
                amount[2] -= 1;
                ans += 1;
            }
        }
        return ans;
    }
};
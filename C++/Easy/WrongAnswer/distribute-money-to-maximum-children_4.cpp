class Solution {
public:
    int distMoney(int money, int children) {
        
        if (money < children + 1 || money > children * 30 || money == 4 * children)
            return -1;
        int ans = 0;
        while (money >= 8) {
            money -= 8;
            ans++;
        }
        return ans;
    }
};
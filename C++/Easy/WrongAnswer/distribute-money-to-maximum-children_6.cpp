class Solution {
public:
    int distMoney(int money, int children) {
        
        int n = money - children;
        if (n > 3 * children) {
            return -1;
        }
        return min(n / 3, children - 1);
    }
};
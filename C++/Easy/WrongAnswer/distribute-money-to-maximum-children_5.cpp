class Solution {
public:
    int distMoney(int money, int children) {
        
        int res = 0;
        int left = money - children;
        if (left < 4 * children) {
            return -1;
        }
        res = left / 8;
        if (res > children) {
            res = children;
        }
        return res;
    }
};
class Solution {
public:
    int distMoney(int money, int children) {
        
        if (money < children + 1) return -1;
        int res = 0;
        while (money > 0) {
            money -= 8;
            if (money < 0) break;
            res++;
        }
        return res;
    }
};
class Solution {
public:
    int distMoney(int money, int children) {
        
        int res = 0;
        if (money < children * 2 || money > children * 8) return -1;
        if (money >= children * 4) return children;
        return money - children * 2;
    }
};
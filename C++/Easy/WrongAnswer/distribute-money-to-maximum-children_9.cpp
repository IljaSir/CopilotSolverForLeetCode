class Solution {
public:
    int distMoney(int money, int children) {
        
        if (money <= children*4) return -1;
        if (money < children*8) return money/8;
        return children-1;
    }
};
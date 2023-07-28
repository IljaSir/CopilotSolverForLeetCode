class Solution {
public:
    int distMoney(int money, int children) {
        
        if (money < children + 1) return -1;
        if (money == children + 1) return children - 1;
        if (money == 2 * children + 1) return children;
        if (money == 3 * children + 1) return children + 1;
        if (money == 4 * children + 1) return -1;
        if (money >= 5 * children + 1) return children;
        return -1;
    }
};
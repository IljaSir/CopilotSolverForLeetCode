class Solution {
public:
    int distMoney(int money, int children) {
        
        int result = 0;
        if (money < children + 2 || money > 200)
            return -1;
        for (int i = 1; i <= children; ++i) {
            if (money - i >= 4 * children)
                result++;
        }
        return result;
    }
};
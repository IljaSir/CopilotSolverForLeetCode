class Solution {
public:
    int distMoney(int money, int children) {
        
        if (money < children * 2 || money > children * 30) {
            return -1;
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= children; ++i) {
            sum += i;
            if (sum + i + 1 <= money && sum + i + 1 + i + 1 > money) {
                ++count;
            }
        }
        return count;
    }
};
class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int res = 0;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += amount[i];
            res += amount[i];
        }
        if (sum % 2 == 0) {
            res += sum / 2;
        } else {
            res += sum / 2 + 1;
        }
        return res;
    }
};
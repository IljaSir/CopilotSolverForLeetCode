class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        vector<int> res;
        int a = num + 1;
        int b = num + 2;
        for (int i = sqrt(a); i >= 1; i--) {
            if (a % i == 0) {
                res.push_back(i);
                res.push_back(a / i);
                break;
            }
        }
        for (int i = sqrt(b); i >= 1; i--) {
            if (b % i == 0) {
                if (abs(res[0] - res[1]) > abs(i - b / i)) {
                    res[0] = i;
                    res[1] = b / i;
                }
                break;
            }
        }
        return res;
    }
};
class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        vector<int> ans;
        int a = num + 1, b = num + 2;
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        int min = INT_MAX;
        for (int i = 1; i <= sqrt(a); i++) {
            if (a % i == 0) {
                if (abs(a / i - i) < min) {
                    min = abs(a / i - i);
                    a1 = i;
                    a2 = a / i;
                }
            }
        }
        min = INT_MAX;
        for (int i = 1; i <= sqrt(b); i++) {
            if (b % i == 0) {
                if (abs(b / i - i) < min) {
                    min = abs(b / i - i);
                    b1 = i;
                    b2 = b / i;
                }
            }
        }
        if (a1 == 0) {
            ans.push_back(b1);
            ans.push_back(b2);
        } else if (b1 == 0) {
            ans.push_back(a1);
            ans.push_back(a2);
        } else {
            if (abs(a1 - a2) < abs(b1 - b2)) {
                ans.push_back(a1);
                ans.push_back(a2);
            } else if (abs(a1 - a2) > abs(b1 - b2)) {
                ans.push_back(b1);
                ans.push_back(b2);
            } else {
                if (a1 < b1) {
                    ans.push_back(a1);
                    ans.push_back(a2);
                } else {
                    ans.push_back(b1);
                    ans.push_back(b2);
                }
            }
        }
        return ans;
    }
};
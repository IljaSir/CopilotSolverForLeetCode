class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        vector<int> ans;
        int p1 = 1;
        int p2 = 1;
        int q1 = 1;
        int q2 = 1;
        int d1 = INT_MAX;
        int d2 = INT_MAX;
        for (int i = 1; i <= sqrt(num+1); i++) {
            if ((num+1) % i == 0) {
                p1 = i;
                p2 = (num+1) / i;
                d1 = abs(p1 - p2);
            }
        }
        for (int i = 1; i <= sqrt(num+2); i++) {
            if ((num+2) % i == 0) {
                q1 = i;
                q2 = (num+2) / i;
                d2 = abs(q1 - q2);
            }
        }
        if (d1 <= d2) {
            ans.push_back(p1);
            ans.push_back(p2);
        }
        else {
            ans.push_back(q1);
            ans.push_back(q2);
        }
        return ans;
    }
};
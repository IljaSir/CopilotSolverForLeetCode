class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        vector<int> res;
        int n = security.size();
        if (time == 0) {
            for (int i = 0; i < n; ++i) {
                res.push_back(i);
            }
            return res;
        }
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        left[0] = security[0];
        for (int i = 1; i < n; ++i) {
            if (i <= time) {
                left[i] = max(left[i-1], security[i]);
            } else {
                left[i] = max(left[i-1], security[i] - security[i-time-1]);
            }
        }
        right[n-1] = security[n-1];
        for (int i = n-2; i >= 0; --i) {
            if (n-i-1 <= time) {
                right[i] = max(right[i+1], security[i]);
            } else {
                right[i] = max(right[i+1], security[i] - security[i+time+1]);
            }
        }
        for (int i = time; i < n-time; ++i) {
            if (left[i] == right[i]) {
                res.push_back(i);
            }
        }
        return res;
    }
};
class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        int n = num.size();
        bool flag = false;
        string res = "";
        for (int i = 0; i < n; i++) {
            int val = num[i] - '0';
            if (change[val] > val) {
                flag = true;
                res += change[val] + '0';
            } else if (change[val] < val) {
                if (flag) break;
                res += val + '0';
            } else {
                res += val + '0';
            }
        }
        if (flag) {
            for (int i = res.size(); i < n; i++) {
                res += num[i];
            }
        }
        return res;
    }
};
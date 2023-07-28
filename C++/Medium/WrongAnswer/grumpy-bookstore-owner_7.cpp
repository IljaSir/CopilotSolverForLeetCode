class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int ans = 0;
        int tmp = 0;
        for (int i = 0; i < n; ++i) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
            else {
                tmp += customers[i];
            }
        }
        int max_tmp = tmp;
        for (int i = 0; i < n - minutes; ++i) {
            if (grumpy[i] == 1) {
                tmp -= customers[i];
            }
            if (grumpy[i + minutes] == 1) {
                tmp += customers[i + minutes];
            }
            max_tmp = max(max_tmp, tmp);
        }
        return ans + max_tmp;
    }
};
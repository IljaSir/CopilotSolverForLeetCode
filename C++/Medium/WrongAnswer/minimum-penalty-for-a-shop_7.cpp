class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int ans = 0;
        int cnt = 0;
        int minCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (customers[i] == 'Y') {
                ++cnt;
            } else {
                --cnt;
            }
            if (minCnt > cnt) {
                minCnt = cnt;
                ans = i + 1;
            }
        }
        return ans;
    }
};
class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        
        int result = 0;
        int max = 1 << requests.size();
        for (int i = 0; i < max; ++i) {
            vector<int> in(n, 0);
            vector<int> out(n, 0);
            int count = 0;
            for (int j = 0; j < requests.size(); ++j) {
                if (i & (1 << j)) {
                    ++out[requests[j][0]];
                    ++in[requests[j][1]];
                    ++count;
                }
            }
            bool ok = true;
            for (int k = 0; k < n; ++k) {
                if (in[k] != out[k]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result = max(result, count);
            }
        }
        return result;
    }
};
class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        
        int result = 0;
        for (int i = 0; i < (1 << requests.size()); ++i) {
            vector<int> count(n);
            int countRequests = 0;
            for (int j = 0; j < requests.size(); ++j) {
                if ((i >> j) & 1) {
                    ++count[requests[j][0]];
                    --count[requests[j][1]];
                    ++countRequests;
                }
            }
            if (all_of(count.begin(), count.end(), [](int x) {return x == 0;})) {
                result = max(result, countRequests);
            }
        }
        return result;
    }
};
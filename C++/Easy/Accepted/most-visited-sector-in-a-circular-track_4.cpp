class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        
        vector<int> res;
        int m = rounds.size();
        int start = rounds[0];
        int end = rounds[m - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res.push_back(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.push_back(i);
            }
            for (int i = start; i <= n; i++) {
                res.push_back(i);
            }
        }
        return res;
    }
};
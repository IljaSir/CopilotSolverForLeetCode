class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        int res = n;
        vector<int> count(k+1, 0);
        for (int i = 0; i < n; i++) {
            count[rolls[i]]++;
            if (i >= k) {
                count[rolls[i-k]]--;
            }
            if (i >= k-1) {
                int max_count = 0;
                for (int j = 1; j <= k; j++) {
                    max_count = max(max_count, count[j]);
                }
                res = min(res, max_count + k - 1);
            }
        }
        return res;
    }
};
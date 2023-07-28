class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end(), greater<int>());
        int n = candidates.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (candidates[i] == 0) break;
            if ((ans & candidates[i]) == 0) {
                ans |= candidates[i];
            }
        }
        int cnt = 0;
        while (ans) {
            cnt++;
            ans >>= 1;
        }
        return cnt;
    }
};
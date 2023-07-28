class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        int n = candidates.size();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                ans = max(ans, candidates[i] & candidates[j]);
            }
        }
        return ans;
    }
};
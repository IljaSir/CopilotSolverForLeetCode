class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        
        int ans = 0;
        int prev = 0;
        for (int i = 0; i < target.size(); i++) {
            ans += max(target[i] - prev, 0);
            prev = target[i];
        }
        return ans;
    }
};
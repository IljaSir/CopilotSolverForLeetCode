class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<bool> visited(n, false);
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = nums[j];
                cnt++;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};
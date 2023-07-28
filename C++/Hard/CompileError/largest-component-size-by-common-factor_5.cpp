class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        vector<int> size(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (__gcd(nums[i], nums[j]) > 1) {
                    unionSet(i, j, parent, size);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = max(ans, size[i]);
        }
        return ans;
    }
};
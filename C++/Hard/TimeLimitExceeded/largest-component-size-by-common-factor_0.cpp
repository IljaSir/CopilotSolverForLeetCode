class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p2] = p1;
                    }
                }
            }
        }
        unordered_map<int, int> group;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            group[p]++;
            ans = max(ans, group[p]);
        }
        return ans;
    }
    
    int find(vector<int> &parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
};
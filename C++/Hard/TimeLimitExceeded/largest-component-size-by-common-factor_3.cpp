class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> p(n);
        for (int i = 0; i < n; i++) p[i] = i;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int j = i + 1; j < n; j++) {
                int b = nums[j];
                if (__gcd(a, b) > 1) p[find(p, j)] = find(p, i);
            }
        }
        unordered_map<int, int> count;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = max(res, ++count[find(p, i)]);
        }
        return res;
    }
    
    int find(vector<int>& p, int i) {
        if (p[i] != i) p[i] = find(p, p[i]);
        return p[i];
    }
};
class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int n = nums.size(), res = 0;
        vector<bool> visited(n, false);
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                ++count;
                visited[start] = true;
            } while (start != nums[i]);
            res = max(res, count);
        }
        return res;
    }
};
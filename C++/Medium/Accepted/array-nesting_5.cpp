class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int n = nums.size();
        vector<bool> visited(n, false);
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int len = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = nums[j];
                len++;
            }
            max_len = max(max_len, len);
        }
        return max_len;
    }
};
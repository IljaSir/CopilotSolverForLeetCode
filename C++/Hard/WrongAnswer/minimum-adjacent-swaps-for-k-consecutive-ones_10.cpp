class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> v;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 1) {
                v.push_back(i);
            }
        }
        int n = v.size();
        int res = INT_MAX;
        for(int i = 0; i < n - k + 1; i++) {
            int mid = i + (k - 1) / 2;
            int l = v[i];
            int r = v[i + k - 1];
            int m = v[mid];
            int val = 0;
            for(int j = i; j < i + k; j++) {
                val += abs(v[j] - m);
            }
            res = min(res, val);
        }
        return res;
    }
};
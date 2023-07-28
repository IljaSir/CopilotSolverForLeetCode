class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        int n = nums.size();
        int m = l.size();
        vector<bool> res(m, false);
        if (n < 2) return res;
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];
            vector<int> cur(nums.begin() + left, nums.begin() + right + 1);
            sort(cur.begin(), cur.end());
            int d = cur[1] - cur[0];
            bool flag = true;
            for (int j = 2; j < cur.size(); j++) {
                if (cur[j] - cur[j - 1] != d) {
                    flag = false;
                    break;
                }
            }
            res[i] = flag;
        }
        return res;
    }
};
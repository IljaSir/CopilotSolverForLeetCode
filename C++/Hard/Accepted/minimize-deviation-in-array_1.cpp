class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        set<int> s;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            s.insert(nums[i]);
        }
        int res = *s.rbegin() - *s.begin();
        while (*s.rbegin() % 2 == 0) {
            int x = *s.rbegin();
            s.erase(x);
            x /= 2;
            s.insert(x);
            res = min(res, *s.rbegin() - *s.begin());
        }
        return res;
    }
};
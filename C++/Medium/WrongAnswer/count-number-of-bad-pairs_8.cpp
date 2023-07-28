class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        map<int, int> m;
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (m.count(num - i)) {
                res += m[num - i];
            }
            m[num - i]++;
        }
        return res;
    }
};
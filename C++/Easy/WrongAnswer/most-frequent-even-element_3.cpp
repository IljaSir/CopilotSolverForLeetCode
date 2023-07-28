class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        map<int, int> m;
        int max = -1;
        int res = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                m[nums[i]]++;
                if (m[nums[i]] > max) {
                    max = m[nums[i]];
                    res = nums[i];
                }
            }
        }
        return res;
    }
};
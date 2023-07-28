class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> freq(100001, 0);
        unordered_map<int, int> count;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            count[freq[num]]--;
            freq[num]++;
            count[freq[num]]++;
            if (count[1] == i + 1) {
                res = i + 1;
            } else if (count[i + 1] == 1) {
                res = i + 1;
            } else if (count[1] == 1) {
                res = i + 1;
            } else if (count[freq[num]] * freq[num] == i) {
                res = i + 1;
            }
        }
        return res;
    }
};
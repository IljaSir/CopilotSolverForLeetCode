class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        unordered_map<int, int> count;
        unordered_map<int, int> freq;
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (count[nums[i]] == 0) {
                count[nums[i]] = 1;
                freq[1]++;
            } else {
                freq[count[nums[i]]]--;
                count[nums[i]]++;
                freq[count[nums[i]]]++;
            }
            if (freq[1] == i+1 || freq[i+1] == 1 || (freq[1] == 1 && freq[i+2] == i+1)) {
                ans = i+1;
            }
        }
        return ans;
    }
};
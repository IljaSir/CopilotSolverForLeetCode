class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        vector<int> evens;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                evens.push_back(nums[i]);
            }
        }
        if (evens.size() == 0) {
            return -1;
        }
        sort(evens.begin(), evens.end());
        int max = 1;
        int count = 1;
        int res = evens[0];
        for (int i = 1; i < evens.size(); i++) {
            if (evens[i] == evens[i-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
                res = evens[i];
            }
        }
        return res;
    }
};
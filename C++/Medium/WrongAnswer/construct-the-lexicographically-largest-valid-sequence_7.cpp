class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> result;
        vector<int> nums;
        for (int i = 1; i <= n; ++i) {
            nums.push_back(i);
            if (i != n) {
                nums.push_back(i);
            }
        }
        sort(nums.begin(), nums.end(), greater<int>());
        int len = nums.size();
        result.resize(len);
        for (int i = 0; i < len; ++i) {
            if (result[i] == 0) {
                result[i] = nums[i];
                int step = nums[i] - 1;
                for (int j = i + 1; j < len; ++j) {
                    if (result[j] == 0) {
                        if (step == 0) {
                            result[j] = nums[i];
                            break;
                        } else {
                            --step;
                        }
                    }
                }
            }
        }
        return result;
    }
};
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        
        // sort the array
        sort(nums.begin(), nums.end());
        
        // use a map to store the sum of two numbers
        map<int, vector<pair<int, int>>> sumMap;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                int sum = nums[i] + nums[j];
                sumMap[sum].push_back(make_pair(i, j));
            }
        }
        
        // find the sum of two numbers
        vector<vector<int>> result;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                int sum = nums[i] + nums[j];
                int diff = target - sum;
                if (sumMap.find(diff) != sumMap.end()) {
                    vector<pair<int, int>> pairs = sumMap[diff];
                    for (auto it = pairs.begin(); it != pairs.end(); ++it) {
                        // check if the numbers are unique
                        if (i == it->first || i == it->second || j == it->first || j == it->second) {
                            continue;
                        }
                        
                        // add the numbers to the result
                        vector<int> quadruplet;
                        quadruplet.push_back(nums[i]);
                        quadruplet.push_back(nums[j]);
                        quadruplet.push_back(nums[it->first]);
                        quadruplet.push_back(nums[it->second]);
                        sort(quadruplet.begin(), quadruplet.end());
                        result.push_back(quadruplet);
                    }
                }
            }
        }
        
        // sort the result
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        
        return result;
    }
};
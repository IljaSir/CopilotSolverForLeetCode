class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> res;
        for (auto& q : queries) {
            int k = q[0], trim = q[1];
            vector<int> nums2;
            for (auto& s : nums) {
                nums2.push_back(stoi(s.substr(0, s.length() - trim + 1)));
            }
            nth_element(nums2.begin(), nums2.begin() + k, nums2.end());
            res.push_back(nums2[k]);
        }
        return res;
    }
};
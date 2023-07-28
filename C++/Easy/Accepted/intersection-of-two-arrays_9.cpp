class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> set;
        for (int i = 0; i < nums1.size(); ++i)
            set.insert(nums1[i]);
        unordered_set<int> res;
        for (int i = 0; i < nums2.size(); ++i) {
            if (set.find(nums2[i]) != set.end())
                res.insert(nums2[i]);
        }
        vector<int> ans;
        for (auto it = res.begin(); it != res.end(); ++it)
            ans.push_back(*it);
        return ans;
    }
};
class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res;
        vector<int> sortedNums1 = nums1;
        sort(sortedNums1.begin(), sortedNums1.end());
        for (int i = 0; i < nums2.size(); i++) {
            auto it = lower_bound(sortedNums1.begin(), sortedNums1.end(), nums2[i] + 1);
            if (it == sortedNums1.end()) {
                res.push_back(sortedNums1[0]);
                sortedNums1.erase(sortedNums1.begin());
            } else {
                res.push_back(*it);
                sortedNums1.erase(it);
            }
        }
        return res;
    }
};
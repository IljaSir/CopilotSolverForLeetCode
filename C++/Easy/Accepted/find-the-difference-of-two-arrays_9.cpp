class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        vector<vector<int>> res;
        vector<int> diff1;
        vector<int> diff2;
        vector<int> tmp;
        for (int i=0; i<nums1.size(); i++) {
            tmp.push_back(nums1[i]);
        }
        for (int i=0; i<nums2.size(); i++) {
            tmp.push_back(nums2[i]);
        }
        sort(tmp.begin(), tmp.end());
        for (int i=0; i<tmp.size(); i++) {
            if (i==0 || tmp[i] != tmp[i-1]) {
                if (find(nums1.begin(), nums1.end(), tmp[i]) == nums1.end()) {
                    diff2.push_back(tmp[i]);
                }
                if (find(nums2.begin(), nums2.end(), tmp[i]) == nums2.end()) {
                    diff1.push_back(tmp[i]);
                }
            }
        }
        res.push_back(diff1);
        res.push_back(diff2);
        return res;
    }
};
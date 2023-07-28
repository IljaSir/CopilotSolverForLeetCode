class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res(nums1.size(), -1);
        vector<int> used(nums1.size(), 0);
        int i, j;
        for (i = 0; i < nums2.size(); i++) {
            int max = -1;
            for (j = 0; j < nums1.size(); j++) {
                if (nums1[j] > nums2[i] && used[j] == 0) {
                    if (max == -1) {
                        max = j;
                    } else if (nums1[j] < nums1[max]) {
                        max = j;
                    }
                }
            }
            if (max != -1) {
                res[i] = nums1[max];
                used[max] = 1;
            }
        }
        for (i = 0; i < nums2.size(); i++) {
            if (res[i] == -1) {
                for (j = 0; j < nums1.size(); j++) {
                    if (used[j] == 0) {
                        res[i] = nums1[j];
                        used[j] = 1;
                        break;
                    }
                }
            }
        }
        return res;
    }
};
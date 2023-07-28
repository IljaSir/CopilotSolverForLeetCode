class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int s1 = 0, s2 = 0;
        for (int i = 0; i < nums1.size(); i++) {
            s1 += nums1[i];
        }
        for (int i = 0; i < nums2.size(); i++) {
            s2 += nums2[i];
        }
        if (s1 == s2) {
            return 0;
        }
        if (s1 > s2) {
            return minOperations(nums2, nums1);
        }
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end(), greater<int>());
        int i = 0, j = 0;
        int cnt = 0;
        while (s1 < s2) {
            int diff = s2 - s1;
            if (i < nums1.size() && j < nums2.size()) {
                int d1 = 6 - nums1[i];
                int d2 = nums2[j] - 1;
                if (d1 > d2) {
                    if (d1 >= diff) {
                        cnt++;
                        break;
                    }
                    s1 += d1;
                    i++;
                } else {
                    if (d2 >= diff) {
                        cnt++;
                        break;
                    }
                    s2 -= d2;
                    j++;
                }
            } else if (i < nums1.size()) {
                int d1 = 6 - nums1[i];
                if (d1 >= diff) {
                    cnt++;
                    break;
                }
                s1 += d1;
                i++;
            } else {
                int d2 = nums2[j] - 1;
                if (d2 >= diff) {
                    cnt++;
                    break;
                }
                s2 -= d2;
                j++;
            }
            cnt++;
        }
        return cnt;
    }
};
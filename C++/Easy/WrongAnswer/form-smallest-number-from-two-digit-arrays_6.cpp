class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        int result = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                int num1 = nums1[i];
                int num2 = nums2[j];
                int num = num1 * 10 + num2;
                if (num < result || result == 0) {
                    result = num;
                }
                num = num2 * 10 + num1;
                if (num < result || result == 0) {
                    result = num;
                }
            }
        }
        return result;
    }
};
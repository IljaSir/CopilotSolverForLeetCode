class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> ans;
        vector<int> count(101, 0);
        for(int i = 0; i < nums1.size(); i++) {
            count[nums1[i]]++;
        }
        for(int i = 0; i < nums2.size(); i++) {
            count[nums2[i]]++;
        }
        for(int i = 0; i < nums3.size(); i++) {
            count[nums3[i]]++;
        }
        for(int i = 0; i < count.size(); i++) {
            if(count[i] >= 2) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};
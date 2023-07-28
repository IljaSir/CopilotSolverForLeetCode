class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res;
        for(int i = 0; i < nums1.size(); i++){
            int j = 0;
            for(; j < nums2.size(); j++){
                if(nums2[j] == nums1[i]){
                    break;
                }
            }
            for(; j < nums2.size(); j++){
                if(nums2[j] > nums1[i]){
                    res.push_back(nums2[j]);
                    break;
                }
            }
            if(j == nums2.size()){
                res.push_back(-1);
            }
        }
        return res;
    }
};
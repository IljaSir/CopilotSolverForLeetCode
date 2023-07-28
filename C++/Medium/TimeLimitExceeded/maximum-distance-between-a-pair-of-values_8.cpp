class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        
        int i=0,j=0;
        int res=0;
        while(j<nums2.size()){
            if(i<nums1.size()&&nums1[i]<=nums2[j]){
                res=max(res,j-i);
                j++;
            }else{
                i++;
            }
        }
        return res;
    }
};
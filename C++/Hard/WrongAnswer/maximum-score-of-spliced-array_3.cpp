class Solution {
public:
    int maximumsSplicedArray(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> v1;
        vector<int> v2;
        v1.push_back(nums1[0]);
        v2.push_back(nums2[0]);
        for(int i=1;i<nums1.size();i++){
            v1.push_back(v1.back()+nums1[i]);
            v2.push_back(v2.back()+nums2[i]);
        }
        int ans = max(v1.back(),v2.back());
        int i=0,j=0;
        while(i<nums1.size() && j<nums2.size()){
            if(nums1[i]==nums2[j]){
                int k = i;
                while(k<nums1.size() && nums1[k]==nums1[i]) k++;
                int l = j;
                while(l<nums2.size() && nums2[l]==nums2[j]) l++;
                ans = max(ans, max(v1[k-1],v2[l-1])+max(v1.back()-v1[k-1],v2.back()-v2[l-1]));
                i=k;
                j=l;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
};
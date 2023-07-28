class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                ans = ans * 10 + nums1[i];
                i++;
            }else if(nums1[i] > nums2[j]){
                ans = ans * 10 + nums2[j];
                j++;
            }else{
                int k = i;
                int l = j;
                while(k < n && l < m && nums1[k] == nums2[l]){
                    k++;
                    l++;
                }
                if(k == n){
                    ans = ans * 10 + nums2[j];
                    j++;
                }else if(l == m){
                    ans = ans * 10 + nums1[i];
                    i++;
                }else if(nums1[k] < nums2[l]){
                    ans = ans * 10 + nums1[i];
                    i++;
                }else{
                    ans = ans * 10 + nums2[j];
                    j++;
                }
            }
        }
        while(i < n){
            ans = ans * 10 + nums1[i];
            i++;
        }
        while(j < m){
            ans = ans * 10 + nums2[j];
            j++;
        }
        return ans;
    }
};
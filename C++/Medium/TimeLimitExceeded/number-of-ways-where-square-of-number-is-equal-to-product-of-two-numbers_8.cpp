class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size(), n2 = nums2.size();
        int ans = 0;
        for(int i = 0; i < n1; i++){
            for(int j = i+1; j < n1; j++){
                long long prod = (long long)nums1[i]*(long long)nums1[j];
                for(int k = 0; k < n2; k++){
                    if(prod == (long long)nums2[k]*(long long)nums2[k]){
                        ans++;
                    }
                }
            }
        }
        for(int i = 0; i < n2; i++){
            for(int j = i+1; j < n2; j++){
                long long prod = (long long)nums2[i]*(long long)nums2[j];
                for(int k = 0; k < n1; k++){
                    if(prod == (long long)nums1[k]*(long long)nums1[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};
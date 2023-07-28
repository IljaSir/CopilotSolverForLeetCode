class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int i = 0;
        int j = 0;
        int k = 0;
        int result = 0;
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                result = result*10 + nums1[i];
                i++;
            }else if(nums1[i] > nums2[j]){
                result = result*10 + nums2[j];
                j++;
            }else{
                int i2 = i;
                int j2 = j;
                while(i2<n1 && j2<n2 && nums1[i2] == nums2[j2]){
                    i2++;
                    j2++;
                }
                if(i2>=n1){
                    result = result*10 + nums2[j];
                    j++;
                }else if(j2>=n2){
                    result = result*10 + nums1[i];
                    i++;
                }else{
                    if(nums1[i2] < nums2[j2]){
                        result = result*10 + nums1[i];
                        i++;
                    }else{
                        result = result*10 + nums2[j];
                        j++;
                    }
                }
            }
        }
        while(i<n1){
            result = result*10 + nums1[i];
            i++;
        }
        while(j<n2){
            result = result*10 + nums2[j];
            j++;
        }
        return result;
    }
};
class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        long long res = 0;
        for(int i = 0; i <= k; ++i){
            int j = k - i;
            if(i > nums1.size() || j > nums2.size()) continue;
            long long tmp = 0;
            vector<int> v;
            for(int l = 0; l < i; ++l) v.push_back(nums1[l]);
            for(int l = 0; l < j; ++l) v.push_back(nums2[l]);
            sort(v.begin(), v.end());
            for(int l = 0; l < k; ++l){
                tmp += v[l];
            }
            res = max(res, tmp);
        }
        return res;
    }
};
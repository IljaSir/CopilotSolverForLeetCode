class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res;
        vector<pair<int,int>> v;
        for(int i=0;i<nums2.size();i++)
        {
            v.push_back(make_pair(nums2[i],i));
        }
        sort(nums1.begin(),nums1.end());
        sort(v.begin(),v.end());
        int i=0,j=0;
        while(i<nums1.size()&&j<v.size())
        {
            if(nums1[i]>v[j].first)
            {
                res.push_back(nums1[i]);
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        i=0;
        while(res.size()<nums1.size())
        {
            if(nums1[i]>v[j].first)
            {
                res.push_back(nums1[i]);
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        vector<int> ans(nums1.size());
        for(int i=0;i<res.size();i++)
        {
            ans[v[i].second]=res[i];
        }
        return ans;
    }
};
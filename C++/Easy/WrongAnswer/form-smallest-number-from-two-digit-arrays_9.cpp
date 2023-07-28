class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        set<int> s1,s2;
        for(auto i:nums1)
            s1.insert(i);
        for(auto i:nums2)
            s2.insert(i);
        int n1=0,n2=0;
        for(auto i:s1)
            n1=n1*10+i;
        for(auto i:s2)
            n2=n2*10+i;
        return min(n1,n2);
    }
};
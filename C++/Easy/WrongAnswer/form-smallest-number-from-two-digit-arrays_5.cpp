class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        string s1, s2;
        for(auto& n: nums1) s1 += to_string(n);
        for(auto& n: nums2) s2 += to_string(n);
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        int i = 0, j = 0;
        string res;
        while(i < s1.size() && j < s2.size()) {
            if(s1[i] < s2[j]) {
                res += s1[i++];
            } else {
                res += s2[j++];
            }
        }
        while(i < s1.size()) res += s1[i++];
        while(j < s2.size()) res += s2[j++];
        return stoi(res);
    }
};
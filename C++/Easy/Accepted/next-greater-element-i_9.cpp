class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> ans(n);
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            m[nums1[i]] = i;
        }
        stack<int> s;
        for (int i = 0; i < nums2.size(); ++i) {
            while (!s.empty() && nums2[s.top()] < nums2[i]) {
                if (m.find(nums2[s.top()]) != m.end()) {
                    ans[m[nums2[s.top()]]] = nums2[i];
                }
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty()) {
            if (m.find(nums2[s.top()]) != m.end()) {
                ans[m[nums2[s.top()]]] = -1;
            }
            s.pop();
        }
        return ans;
    }
};
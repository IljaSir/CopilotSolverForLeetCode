class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_map<int, int> map;
        stack<int> st;
        for(int i = 0; i < nums2.size(); i++) {
            while(!st.empty() && nums2[i] > st.top()) {
                map[st.top()] = nums2[i];
                st.pop();
            }
            st.push(nums2[i]);
        }
        while(!st.empty()) {
            map[st.top()] = -1;
            st.pop();
        }
        vector<int> res;
        for(int i = 0; i < nums1.size(); i++) {
            res.push_back(map[nums1[i]]);
        }
        return res;
    }
};
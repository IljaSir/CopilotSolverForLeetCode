class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> ans(n, -1);
        unordered_map<int, int> mp;
        for(int i = 0; i < n; i++){
            mp[nums1[i]] = i;
        }
        stack<int> st;
        for(int i = 0; i < nums2.size(); i++){
            while(!st.empty() && nums2[st.top()] < nums2[i]){
                if(mp.find(nums2[st.top()]) != mp.end()){
                    ans[mp[nums2[st.top()]]] = nums2[i];
                }
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};
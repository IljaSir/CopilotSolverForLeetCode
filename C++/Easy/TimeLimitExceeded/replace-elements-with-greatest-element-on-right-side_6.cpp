class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> ans(n, -1);
        for (int i = 0; i < n - 1; i++) {
            ans[i] = *max_element(arr.begin() + i + 1, arr.end());
        }
        return ans;
    }
};
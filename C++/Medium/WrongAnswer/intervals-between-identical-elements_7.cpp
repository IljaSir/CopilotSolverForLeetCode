class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> ans(n, 0);
        vector<int> pos(100001, -1);
        for (int i = 0; i < n; i++) {
            if (pos[arr[i]] != -1) {
                ans[i] = ans[pos[arr[i]]];
            }
            ans[i] += i - pos[arr[i]];
            pos[arr[i]] = i;
        }
        return ans;
    }
    vector<int> getSumOfDistances(vector<int>& arr) {
        vector<long long> left = getDistances(arr);
        reverse(arr.begin(), arr.end());
        vector<long long> right = getDistances(arr);
        vector<int> ans(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = left[i] + right[arr.size() - 1 - i];
        }
        return ans;
    }
};
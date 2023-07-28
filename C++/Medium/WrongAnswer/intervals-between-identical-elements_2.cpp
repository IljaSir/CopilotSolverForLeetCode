class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> res(n, 0);
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && arr[j] == arr[i]) {
                ++j;
            }
            if (j < n) {
                res[i] = j - i;
            }
            --j;
            if (j > i) {
                res[j] = j - i;
            }
            int k = i - 1;
            while (k >= 0 && arr[k] == arr[i]) {
                --k;
            }
            ++k;
            if (k < i) {
                res[k] = i - k;
            }
            while (k < i) {
                res[k] += i - k;
                res[i] += i - k;
                ++k;
            }
            i = j;
        }
        return res;
    }
    vector<int> getSumAbsoluteDifferences(vector<int>& arr) {
        vector<long long> res = getDistances(arr);
        int n = arr.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; ++i) {
            ans[i] = res[i] * arr[i] - (res[i] * (res[i] - 1) / 2);
        }
        return ans;
    }
};
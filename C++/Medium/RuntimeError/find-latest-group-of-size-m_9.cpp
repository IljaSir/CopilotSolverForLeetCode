class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        if (n == m) {
            return n;
        }
        vector<int> count(n+1, 0);
        vector<int> group(n+1, 0);
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            count[a] = 1;
            if (a-1 >= 1 && count[a-1] > 0) {
                group[group[a-1]] -= count[a-1];
                group[group[a]] += count[a-1];
                count[a] += count[a-1];
                count[a-1] = 0;
            }
            if (a+1 <= n && count[a+1] > 0) {
                group[group[a+1]] -= count[a+1];
                group[group[a]] += count[a+1];
                count[a] += count[a+1];
                count[a+1] = 0;
            }
            group[count[a]]++;
            if (group[m] > 0) {
                ans = i+1;
            }
        }
        return ans;
    }
};
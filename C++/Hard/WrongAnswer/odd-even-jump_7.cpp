class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> next(n, 0);
        vector<int> odd(n, 0);
        vector<int> even(n, 0);
        map<int, int> mp;
        mp[arr[n-1]] = n-1;
        next[n-1] = n-1;
        odd[n-1] = 1;
        even[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            auto it = mp.lower_bound(arr[i]);
            if (it != mp.end()) {
                next[i] = it->second;
            }
            if (it != mp.begin()) {
                it--;
                even[i] = odd[it->second];
            }
            odd[i] = even[next[i]];
            mp[arr[i]] = i;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += odd[i];
        }
        return res;
    }
};
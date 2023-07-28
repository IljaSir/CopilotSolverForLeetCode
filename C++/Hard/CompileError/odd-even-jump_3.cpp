class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size(), res = 1;
        vector<int> next(n), prev(n);
        map<int, int> m;
        m[arr[n-1]] = n-1;
        next[n-1] = prev[n-1] = -1;
        for (int i = n-2; i >= 0; i--) {
            auto it = m.lower_bound(arr[i]);
            if (it != m.end()) next[i] = it->second;
            else next[i] = -1;
            if (it != m.begin()) prev[i] = prev(it)->second;
            else prev[i] = -1;
            m[arr[i]] = i;
        }
        vector<bool> odd(n), even(n);
        odd[n-1] = even[n-1] = true;
        for (int i = n-2; i >= 0; i--) {
            if (next[i] != -1) odd[i] = even[next[i]];
            if (prev[i] != -1) even[i] = odd[prev[i]];
            if (odd[i]) res++;
        }
        return res;
    }
};
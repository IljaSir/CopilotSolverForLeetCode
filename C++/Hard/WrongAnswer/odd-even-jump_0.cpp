class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> odd(n, -1), even(n, -1);
        map<int, int> m;
        m[arr[n - 1]] = n - 1;
        odd[n - 1] = even[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            auto it = m.lower_bound(arr[i]);
            if (it != m.end()) {
                odd[i] = even[it->second];
            }
            it = m.upper_bound(arr[i]);
            if (it != m.begin()) {
                even[i] = odd[(--it)->second];
            }
            m[arr[i]] = i;
        }
        return accumulate(odd.begin(), odd.end(), 0);
    }
};
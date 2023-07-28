class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        int n = arr.size();
        if (k == n) return 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto it : m) {
            v.push_back(it.second);
        }
        sort(v.begin(), v.end());
        int i = 0;
        while (k > 0) {
            k -= v[i];
            i++;
        }
        if (k == 0) return v.size() - i;
        return v.size() - i + 1;
    }
};
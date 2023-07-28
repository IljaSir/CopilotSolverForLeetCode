class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (int i : arr) {
            m[i]++;
        }
        vector<int> f;
        for (auto p : m) {
            f.push_back(p.second);
        }
        sort(f.begin(), f.end());
        int i = 0;
        while (i < f.size() && k >= f[i]) {
            k -= f[i++];
        }
        return f.size() - i;
    }
};
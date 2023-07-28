class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (int i=0; i<arr.size(); ++i) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto p : m) {
            v.push_back(p.second);
        }
        sort(v.begin(), v.end());
        int i=0;
        while (i<v.size() && k>=v[i]) {
            k -= v[i++];
        }
        return v.size()-i;
    }
};
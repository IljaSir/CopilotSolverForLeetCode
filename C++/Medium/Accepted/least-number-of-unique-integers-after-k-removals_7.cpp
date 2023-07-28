class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int,int> m;
        for (auto n : arr) m[n]++;
        vector<int> v;
        for (auto p : m) v.push_back(p.second);
        sort(v.begin(),v.end());
        int i = 0;
        for (; i < v.size(); i++) {
            if (v[i] <= k) k -= v[i];
            else break;
        }
        return v.size() - i;
    }
};
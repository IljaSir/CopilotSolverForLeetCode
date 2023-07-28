class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        map<int,int> m;
        for (auto x: arr) m[x]++;
        vector<int> v;
        for (auto x: m) v.push_back(x.second);
        sort(v.begin(), v.end());
        int i = 0;
        while (k > 0) {
            k -= v[i++];
        }
        return v.size() - i + (k == 0 ? 0 : 1);
    }
};
class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        map<int, int> m;
        for (auto a: arr) m[a]++;
        vector<pair<int, int>> v;
        for (auto p: m) v.push_back(p);
        sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) {return a.second < b.second;});
        int i = 0;
        while (k > 0) {
            k -= v[i].second;
            i++;
        }
        return v.size() - i + (k == 0 ? 0 : 1);
    }
};
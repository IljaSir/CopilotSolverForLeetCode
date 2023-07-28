class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        map<int, int> m;
        for (auto a: arr) m[a]++;
        vector<int> v;
        for (auto it = m.begin(); it != m.end(); it++) v.push_back(it->second);
        sort(v.begin(), v.end(), greater<int>());
        int n = arr.size(), i = 0, sum = 0;
        while (sum < n/2) sum += v[i++];
        return i;
    }
};
class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        int n = arr.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(it->second);
        }
        sort(v.begin(), v.end(), greater<int>());
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v[i];
            ans++;
            if (sum * 2 >= n) {
                break;
            }
        }
        return ans;
    }
};
class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        map<int, int> m;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(it->second);
        }
        sort(v.begin(), v.end(), greater<int>());
        int sum = 0;
        int count = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v[i];
            count++;
            if (sum >= n / 2) {
                break;
            }
        }
        return count;
    }
};
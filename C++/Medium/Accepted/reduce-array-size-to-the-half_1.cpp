class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(it->second);
        }
        sort(v.begin(), v.end(), greater<int>());
        int n = arr.size();
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
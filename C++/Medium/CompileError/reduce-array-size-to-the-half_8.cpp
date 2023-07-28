class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> m;
        vector<int> v;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]]++;
        }
        for (auto& [k, v]: m) {
            v.push_back(v);
        }
        sort(v.begin(), v.end(), greater<int>());
        int sum = 0;
        int result = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v[i];
            result++;
            if (sum >= arr.size() / 2) {
                break;
            }
        }
        return result;
    }
};
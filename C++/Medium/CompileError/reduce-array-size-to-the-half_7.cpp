class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> count;
        for (auto& i : arr) {
            count[i]++;
        }
        vector<int> v;
        for (auto& [k, v] : count) {
            v.push_back(v);
        }
        sort(v.begin(), v.end(), greater<int>());
        int sum = 0;
        for (int i = 0; i < v.size(); ++i) {
            sum += v[i];
            if (sum >= arr.size() / 2) {
                return i + 1;
            }
        }
        return 0;
    }
};
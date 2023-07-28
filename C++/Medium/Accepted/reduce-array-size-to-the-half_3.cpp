class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i : arr) {
            ++m[i];
        }
        vector<int> v;
        for (auto i : m) {
            v.push_back(i.second);
        }
        sort(v.begin(), v.end(), greater<int>());
        int sum = 0, count = 0;
        for (int i : v) {
            sum += i;
            ++count;
            if (sum >= arr.size() / 2) {
                break;
            }
        }
        return count;
    }
};
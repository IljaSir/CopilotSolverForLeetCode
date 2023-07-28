class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> count;
        for (int i : arr) {
            ++count[i];
        }
        vector<int> a;
        for (auto p : count) {
            a.push_back(p.second);
        }
        sort(a.begin(), a.end(), greater<int>());
        int n = arr.size();
        int ans = 0;
        for (int i = 0; i < a.size(); ++i) {
            n -= a[i];
            ++ans;
            if (n <= arr.size() / 2) {
                break;
            }
        }
        return ans;
    }
};
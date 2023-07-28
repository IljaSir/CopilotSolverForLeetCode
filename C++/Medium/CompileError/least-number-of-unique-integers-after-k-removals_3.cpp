class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (auto &i : arr) {
            m[i]++;
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        for (auto &i : m) {
            q.push({i.second, i.first});
        }
        while (k > 0 && !q.empty()) {
            auto &i = q.top();
            if (i.first > k) {
                i.first -= k;
                k = 0;
            } else {
                k -= i.first;
                q.pop();
            }
        }
        return q.size();
    }
};
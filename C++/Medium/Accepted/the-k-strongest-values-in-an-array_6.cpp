class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int m = arr[(n-1)/2];
        auto cmp = [&](int a, int b) {
            if (abs(a-m) != abs(b-m)) {
                return abs(a-m) > abs(b-m);
            }
            return a > b;
        };
        priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);
        for (int i = 0; i < n; i++) {
            pq.push(arr[i]);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<int> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top());
            pq.pop();
        }
        return ans;
    }
};
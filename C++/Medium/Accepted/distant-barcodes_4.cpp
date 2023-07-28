class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        int n = barcodes.size();
        vector<int> ans(n);
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            cnt[barcodes[i]]++;
        }
        priority_queue<pair<int, int>> pq;
        for (auto [k, v] : cnt) {
            pq.push({v, k});
        }
        int pos = 0;
        while (!pq.empty()) {
            auto [cnt, num] = pq.top();
            pq.pop();
            for (int i = 0; i < cnt; ++i) {
                ans[pos] = num;
                pos += 2;
                if (pos >= n) {
                    pos = 1;
                }
            }
        }
        return ans;
    }
};
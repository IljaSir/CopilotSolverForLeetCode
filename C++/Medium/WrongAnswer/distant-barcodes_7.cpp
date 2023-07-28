class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        int n = barcodes.size();
        unordered_map<int, int> freq;
        for (int i: barcodes) {
            freq[i]++;
        }
        priority_queue<pair<int, int>> pq;
        for (auto it = freq.begin(); it != freq.end(); it++) {
            pq.push(make_pair(it->second, it->first));
        }
        vector<int> ans(n);
        int i = 0;
        while (!pq.empty()) {
            pair<int, int> p1 = pq.top();
            pq.pop();
            ans[i] = p1.second;
            i += 2;
            if (i >= n) i = 1;
            if (p1.first > 1) {
                p1.first--;
                pq.push(p1);
            }
        }
        return ans;
    }
};
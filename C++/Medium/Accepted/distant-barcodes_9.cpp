class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        vector<int> ret;
        map<int, int> counts;
        for (auto b : barcodes) {
            counts[b]++;
        }
        auto cmp = [](pair<int, int> a, pair<int, int> b) {
            return a.second < b.second;
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);
        for (auto c : counts) {
            pq.push(c);
        }
        while (pq.size() >= 2) {
            auto a = pq.top();
            pq.pop();
            auto b = pq.top();
            pq.pop();
            ret.push_back(a.first);
            ret.push_back(b.first);
            a.second--;
            b.second--;
            if (a.second > 0) {
                pq.push(a);
            }
            if (b.second > 0) {
                pq.push(b);
            }
        }
        if (!pq.empty()) {
            ret.push_back(pq.top().first);
        }
        return ret;
    }
};
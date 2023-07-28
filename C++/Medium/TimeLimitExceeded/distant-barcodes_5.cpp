class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        unordered_map<int, int> count;
        for (int i = 0; i < barcodes.size(); ++i) {
            count[barcodes[i]]++;
        }
        vector<pair<int, int>> sorted;
        for (auto it = count.begin(); it != count.end(); ++it) {
            sorted.push_back(make_pair(it->first, it->second));
        }
        sort(sorted.begin(), sorted.end(), [](pair<int, int> a, pair<int, int> b) {
            return a.second > b.second;
        });
        vector<int> result;
        for (int i = 0; i < sorted.size(); ++i) {
            result.push_back(sorted[i].first);
            sorted[i].second--;
        }
        int i = 0;
        while (i < sorted.size()) {
            if (sorted[i].second == 0) {
                i++;
                continue;
            }
            for (int j = 0; j < result.size(); ++j) {
                if (result[j] == sorted[i].first) {
                    continue;
                }
                if (j + 1 < result.size() && result[j + 1] == sorted[i].first) {
                    continue;
                }
                result.insert(result.begin() + j + 1, sorted[i].first);
                sorted[i].second--;
                break;
            }
        }
        return result;
    }
};
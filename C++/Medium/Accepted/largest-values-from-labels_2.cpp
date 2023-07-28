class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        vector<pair<int, int>> items;
        for (int i = 0; i < values.size(); ++i) {
            items.push_back({values[i], labels[i]});
        }
        sort(items.begin(), items.end(), [](const pair<int, int>& p1, const pair<int, int>& p2) {
            return p1.first > p2.first;
        });
        unordered_map<int, int> label_count;
        int sum = 0;
        for (int i = 0; i < items.size(); ++i) {
            if (numWanted == 0) {
                break;
            }
            if (label_count[items[i].second] < useLimit) {
                sum += items[i].first;
                label_count[items[i].second]++;
                numWanted--;
            }
        }
        return sum;
    }
};
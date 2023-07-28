class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        vector<long long> distances(arr.size(), 0);
        for (int i = 0; i < arr.size(); ++i) {
            if (i > 0) {
                distances[i] = distances[i - 1] + i;
            }
        }
        for (int i = arr.size() - 1; i >= 0; --i) {
            if (i < arr.size() - 1) {
                distances[i] += distances[i + 1] - (arr.size() - i - 1);
            }
        }
        return distances;
    }
    vector<int> countMoves(vector<int>& arr) {
        vector<int> answer(arr.size(), 0);
        unordered_map<int, vector<int>> positions;
        for (int i = 0; i < arr.size(); ++i) {
            positions[arr[i]].push_back(i);
        }
        for (auto& [_, pos] : positions) {
            auto distances = getDistances(pos);
            for (int i = 0; i < pos.size(); ++i) {
                answer[pos[i]] = distances[i];
            }
        }
        return answer;
    }
};
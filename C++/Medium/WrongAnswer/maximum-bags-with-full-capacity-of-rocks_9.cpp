class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        auto n = capacity.size();
        auto low = 0;
        auto high = n;
        while (low < high) {
            auto mid = low + (high - low + 1) / 2;
            if (check(mid, capacity, rocks, additionalRocks)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    bool check(int mid, vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        auto n = capacity.size();
        auto sum = 0;
        for (auto i = 0; i < n; ++i) {
            if (capacity[i] - rocks[i] >= mid) {
                sum += capacity[i] - rocks[i] - mid;
            }
        }
        return sum <= additionalRocks;
    }
};
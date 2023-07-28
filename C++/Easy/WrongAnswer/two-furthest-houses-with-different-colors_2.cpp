class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        int ans = 0;
        unordered_map<int, int> first, last;
        for (int i = 0; i < n; i++) {
            if (first.find(colors[i]) == first.end()) {
                first[colors[i]] = i;
            }
            last[colors[i]] = i;
        }
        for (auto& [color, index]: first) {
            if (index != last[color]) {
                ans = max(ans, last[color] - index);
            }
        }
        return ans;
    }
};
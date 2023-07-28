class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        for (int i = 1; i < n; i++) {
            int j = n - i;
            if (std::to_string(i).find('0') == std::string::npos &&
                std::to_string(j).find('0') == std::string::npos) {
                return {i, j};
            }
        }
        return {};
    }
};
class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        vector<int> result;
        for (int i = 1; i < n; i++) {
            if (to_string(i).find('0') == string::npos && to_string(n - i).find('0') == string::npos) {
                result.push_back(i);
                result.push_back(n - i);
                break;
            }
        }
        return result;
    }
};
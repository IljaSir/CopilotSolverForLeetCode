class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> result;
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (i == target.size()) {
                break;
            }
            if (j == target[i]) {
                result.push_back("Push");
                i++;
            } else {
                result.push_back("Push");
                result.push_back("Pop");
            }
        }
        return result;
    }
};
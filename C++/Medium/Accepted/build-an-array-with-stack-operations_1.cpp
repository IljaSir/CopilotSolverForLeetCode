class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> result;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (i == target[j]) {
                result.push_back("Push");
                j++;
            } else {
                result.push_back("Push");
                result.push_back("Pop");
            }
            if (j == target.size()) {
                break;
            }
        }
        return result;
    }
};
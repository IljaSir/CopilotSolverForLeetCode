class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> result;
        int i = 0;
        for (int j = 1; j <= n && i < target.size(); j++) {
            result.push_back("Push");
            if (j == target[i]) {
                i++;
            } else {
                result.push_back("Pop");
            }
        }
        return result;
    }
};
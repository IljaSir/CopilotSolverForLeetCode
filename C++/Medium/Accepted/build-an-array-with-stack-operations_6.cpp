class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> res;
        int i = 1;
        for (auto& t : target) {
            while (i < t) {
                res.push_back("Push");
                res.push_back("Pop");
                ++i;
            }
            res.push_back("Push");
            ++i;
        }
        return res;
    }
};
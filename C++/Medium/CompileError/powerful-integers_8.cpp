class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vector<int> result;
        unordered_set<int> set;
        int i = 0;
        while (pow(x, i) <= bound) {
            int j = 0;
            while (pow(x, i) + pow(y, j) <= bound) {
                int sum = pow(x, i) + pow(y, j);
                if (set.find(sum) == set.end()) {
                    result.push_back(sum);
                    set.insert(sum);
                }end());
        return ans;
    }
};
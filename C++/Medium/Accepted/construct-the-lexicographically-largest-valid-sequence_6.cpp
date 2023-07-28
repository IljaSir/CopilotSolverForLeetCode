class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        int size = 2 * n - 1;
        vector<int> result(size, 0);
        vector<bool> used(n + 1, false);
        construct(result, used, 0);
        return result;
    }
    
    bool construct(vector<int>& result, vector<bool>& used, int index) {
        if (index >= result.size()) {
            return true;
        }
        
        if (result[index] != 0) {
            return construct(result, used, index + 1);
        }
        
        for (int i = used.size() - 1; i >= 1; --i) {
            if (used[i]) {
                continue;
            }
            
            if (i == 1) {
                result[index] = 1;
                used[i] = true;
                if (construct(result, used, index + 1)) {
                    return true;
                }
                result[index] = 0;
                used[i] = false;
            } else {
                if (index + i >= result.size()) {
                    continue;
                }
                if (result[index + i] != 0) {
                    continue;
                }
                result[index] = i;
                result[index + i] = i;
                used[i] = true;
                if (construct(result, used, index + 1)) {
                    return true;
                }
                result[index] = 0;
                result[index + i] = 0;
                used[i] = false;
            }
        }
        
        return false;
    }
};
class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> output;
        if (changed.size() % 2 != 0) return output;
        sort(changed.begin(), changed.end());
        int i = 0;
        while (i < changed.size()) {
            if (changed[i] == 0) {
                for (int j = i; j < changed.size() - 1; j++) {
                    changed[j] = changed[j + 1];
                }
                changed.pop_back();
                continue;
            }
            int j = i + 1;
            while (j < changed.size()) {
                if (changed[j] == 2 * changed[i]) {
                    for (int k = j; k < changed.size() - 1; k++) {
                        changed[k] = changed[k + 1];
                    }
                    changed.pop_back();
                    break;
                }
                j++;
            }
            if (j == changed.size()) return output;
            i++;
        }
        return changed;
    }
};
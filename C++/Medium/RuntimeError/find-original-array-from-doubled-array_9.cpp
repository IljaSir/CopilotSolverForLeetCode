class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> res;
        sort(changed.begin(), changed.end());
        while (changed.size() > 0) {
            int num = changed[0];
            if (num == 0) {
                changed.erase(changed.begin());
                continue;
            }
            int num2 = num * 2;
            auto it = find(changed.begin(), changed.end(), num2);
            if (it == changed.end()) {
                return vector<int>();
            }
            res.push_back(num);
            changed.erase(changed.begin());
            changed.erase(it);
        }
        return res;
    }
};
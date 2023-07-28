class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> counter;
        for (int i = 0; i < arr.size(); i++) {
            counter[arr[i]]++;
        }
        for (auto it = counter.begin(); it != counter.end(); it++) {
            int key = it->first;
            int value = it->second;
            if (value == 0) {
                continue;
            }
            if (key < 0) {
                if (key % 2 != 0) {
                    return false;
                }
                if (counter[key / 2] < value) {
                    return false;
                }
                counter[key / 2] -= value;
            } else {
                if (counter[key * 2] < value) {
                    return false;
                }
                counter[key * 2] -= value;
            }
        }
        return true;
    }
};
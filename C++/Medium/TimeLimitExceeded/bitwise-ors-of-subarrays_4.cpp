class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        set<int> s;
        for (int i = 0; i < arr.size(); ++i) {
            int t = arr[i];
            s.insert(t);
            for (int j = i + 1; j < arr.size(); ++j) {
                t |= arr[j];
                s.insert(t);
            }
        }
        return s.size();
    }
};
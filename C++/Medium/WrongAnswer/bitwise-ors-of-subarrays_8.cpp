class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> s1, s2, s3;
        for (int i = 0; i < arr.size(); i++) {
            s1.insert(arr[i]);
            for (auto& x : s2) {
                s1.insert(x | arr[i]);
            }
            s2 = s1;
        }
        return s2.size();
    }
};
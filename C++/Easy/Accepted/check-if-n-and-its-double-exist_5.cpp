class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        
        unordered_set<int> s;
        for (int n : arr) {
            if (s.count(n * 2) || (n % 2 == 0 && s.count(n / 2))) {
                return true;
            }
            s.insert(n);
        }
        return false;
    }
};
class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        
        vector<int> res;
        string s = "123456789";
        for (int i = 0; i < s.size(); ++i) {
            for (int j = i; j < s.size(); ++j) {
                int num = stoi(s.substr(i, j - i + 1));
                if (num >= low && num <= high) {
                    res.push_back(num);
                }
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};
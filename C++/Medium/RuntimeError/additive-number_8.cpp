class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        return isAdditiveNumber(num, 0, 0, 0, 0);
    }
    bool isAdditiveNumber(const string& num, int start, long long sum, long long prev, int k) {
        if (start == num.size() && k > 2) return true;
        for (int i = start; i < num.size(); i++) {
            long long cur = stoll(num.substr(start, i - start + 1));
            if (num[start] == '0' && i > start) break;
            if (k >= 2 && cur != sum) continue;
            if (isAdditiveNumber(num, i + 1, prev + cur, cur, k + 1)) return true;
        }
        return false;
    }
};
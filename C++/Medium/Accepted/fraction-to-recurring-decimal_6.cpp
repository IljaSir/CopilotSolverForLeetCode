class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        long long num = numerator;
        long long den = denominator;
        if (num % den == 0) {
            return to_string(num / den);
        }
        string ans;
        if ((num > 0) ^ (den > 0)) {
            ans += '-';
        }
        num = abs(num);
        den = abs(den);
        ans += to_string(num / den) + '.';
        num %= den;
        unordered_map<int, int> mp;
        while (num != 0) {
            mp[num] = ans.size();
            num *= 10;
            ans += to_string(num / den);
            num %= den;
            if (mp.count(num)) {
                ans.insert(mp[num], 1, '(');
                ans += ')';
                break;
            }
        }
        return ans;
    }
};
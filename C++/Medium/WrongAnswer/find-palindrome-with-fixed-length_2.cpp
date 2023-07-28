class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> answer;
        for (int i = 0; i < queries.size(); i++) {
            answer.push_back(getKthPalindrome(queries[i], intLength));
        }
        return answer;
    }
    
    long long getKthPalindrome(int k, int intLength) {
        if (k < 0) return -1;
        if (k == 0) return 0;
        if (k == 1) return 1;
        if (k == 2) return 11;
        if (intLength == 1) return k;
        if (intLength == 2) {
            if (k > 9) return -1;
            return k * 10 + k;
        }
        if (k > 10) {
            int base = 1;
            for (int i = 0; i < intLength - 2; i++) {
                base *= 10;
            }
            int num = k / 10;
            int rem = k % 10;
            if (rem == 0) {
                num--;
                rem = 9;
            }
            else {
                rem--;
            }
            if (rem == 0) {
                return num * base + getKthPalindrome(9, intLength - 2) * 10 + num;
            }
            else {
                return num * base + getKthPalindrome(rem, intLength - 2) * 10 + num;
            }
        }
        else {
            if (k == 3) return 101;
            if (k == 4) return 111;
            if (k == 5) return 121;
            if (k == 6) return 131;
            if (k == 7) return 141;
            if (k == 8) return 151;
            if (k == 9) return 161;
            if (k == 10) return 171;
        }
        return -1;
    }
};
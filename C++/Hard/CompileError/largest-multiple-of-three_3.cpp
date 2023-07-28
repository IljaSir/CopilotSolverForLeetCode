class Solution {
public:
    string largestMultipleOfThree(vector<int>& digits) {
        
        int sum = 0;
        vector<int> cnt(10, 0);
        for (int i = 0; i < digits.size(); ++i) {
            cnt[digits[i]]++;
            sum += digits[i];
        }
        if (sum == 0) {
            return "0";
        }
        int mod = sum % 3;
        if (mod == 0) {
            return build(cnt);
        }
        if (mod == 1) {
            if (cnt[1] > 0) {
                cnt[1]--;
            } else if (cnt[4] > 0) {
                cnt[4]--;
            } else if (cnt[7] > 0) {
                cnt[7]--;
            } else if (cnt[2] > 1) {
                cnt[2] -= 2;
            } else if (cnt[5] > 1) {
                cnt[5] -= 2;
            } else if (cnt[8] > 1) {
                cnt[8] -= 2;
            } else if (cnt[2] > 0 && cnt[5] > 0) {
                cnt[2]--;
                cnt[5]--;
            } else if (cnt[2] > 0 && cnt[8] > 0) {
                cnt[2]--;
                cnt[8]--;
            } else if (cnt[5] > 0 && cnt[8] > 0) {
                cnt[5]--;
                cnt[8]--;
            } else {
                return "";
            }
        } else {
            if (cnt[2] > 0) {
                cnt[2]--;
            } else if (cnt[5] > 0) {
                cnt[5]--;
            } else if (cnt[8] > 0) {
                cnt[8]--;
            } else if (cnt[1] > 1) {
                cnt[1] -= 2;
            } else if (cnt[4] > 1) {
                cnt[4] -= 2;
            } else if (cnt[7] > 1) {
                cnt[7] -= 2;
            } else if (cnt[1] > 0 && cnt[4] > 0) {
                cnt[1]--;
                cnt[4]--;
            } else if (cnt[1]
    }
};
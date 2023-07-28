class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.length();
        int mid = len/2;
        string left = n.substr(0, mid);
        string right = n.substr(len-mid, mid);
        long long leftNum = stoll(left);
        long long rightNum = stoll(right);
        long long num = stoll(n);
        long long minDiff = INT_MAX;
        long long minNum = 0;
        long long num1 = getNum(leftNum-1, len);
        long long num2 = getNum(leftNum, len);
        long long num3 = getNum(leftNum+1, len);
        vector<long long> candidates{num1, num2, num3};
        for(auto c: candidates){
            if(c == num) continue;
            long long diff = abs(num-c);
            if(diff < minDiff){
                minDiff = diff;
                minNum = c;
            }else if(diff == minDiff){
                minNum = min(minNum, c);
            }
        }
        return to_string(minNum);
    }
};
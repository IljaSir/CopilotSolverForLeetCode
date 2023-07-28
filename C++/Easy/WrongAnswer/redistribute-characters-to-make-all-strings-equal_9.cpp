class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += words[i].length();
        }
        if (sum % n != 0) return false;
        int avg = sum / n;
        for (int i = 0; i < n; i++) {
            if (words[i].length() != avg) return false;
        }
        return true;
    }
};
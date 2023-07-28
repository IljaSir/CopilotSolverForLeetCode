class Solution {
public:
    int minFlips(string target) {
        
        int n = target.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (target[i] == '1') count++;
            while (i < n - 1 && target[i] == target[i + 1]) i++;
        }
        return count;
    }
};
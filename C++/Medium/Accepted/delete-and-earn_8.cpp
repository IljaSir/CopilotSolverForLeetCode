class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        vector<int> count(10001, 0);
        for (int num : nums) {
            count[num]++;
        }
        int use = 0, avoid = 0;
        for (int i = 1; i <= 10000; i++) {
            int m = max(use, avoid);
            use = i * count[i] + avoid;
            avoid = m;
        }
        return max(use, avoid);
    }
};
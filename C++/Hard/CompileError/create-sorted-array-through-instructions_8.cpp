class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        vector<int> num(100002, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + min(get(num, instructions[i] - 1), i - get(num, instructions[i]))) % 1000000007;
            update(num, instructions[i]);
        }
        return ans;
    }
    
    int get(vector<int>& num, int i) {
        int sum = 0;
        while (i > 0) {
            sum += num[i];
            i -= lowbit(i);
        }
        return sum;
    }
    
    void update(vector<int>& num, int i) {
        while (i < num.size()) {
            num[i]++;
            i += lowbit(i);
        }
    }
};
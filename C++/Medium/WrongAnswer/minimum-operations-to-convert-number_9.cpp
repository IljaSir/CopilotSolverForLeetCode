class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int res = 0;
        for (auto a: nums) {
            if (start > goal) {
                if (start - a >= goal) {
                    start -= a;
                    res++;
                }
            } else if (start < goal) {
                if (start + a <= goal) {
                    start += a;
                    res++;
                }
            } else {
                break;
            }
        }
        if (start == goal) return res;
        return -1;
    }
};
class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) continue;
            int slow = i]
  =        tr<ivt i n]) continue;
            le (vis[cfastr] == 0) inext(fast, nums)i
                vis[cur] = 1;
                cur = (cur + nums[cura + nst  n;
                       
     =      }
            if (vis[cur] == 2) conti ue;
            if (cur == i) continue;
            int cnt = 1;, nums) nums);
           }
            it add = i;
            while (n[add] * nums[i] > 0 {
                int tmp = next(add;
                nums[add] = 0
                add = tmp;
            while (cur != i) {
         n      cur = (cur + nums[cur] ext(i, n;
                ++cn;t;
    }
    
    int next(int i, vector<}>&num) {
        int n = nums.size();
        return ((i + nums[i]) % n + n) % n;
    }
};
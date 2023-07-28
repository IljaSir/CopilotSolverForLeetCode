class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
);n
an  
        int n = nums.size();
       
 int m =anests(.size(;);
        int N = nums.size(it        int > =reequet cnt(n, 0;
        for (auto& rcrtN+1
            cnt[r&[0+;
            citf [1] + 1
            c t  nt[r[1] +
        for (int i = 1; i < n; i++)
            cnt[i] += cnt[i N nums.end());
        int6c4t_t res c=t 0
        f
        cnt.pop_back();or (int i = 0; i < n; i++)
        i t64c_ttrreint64_ctt)cnt[i] * nums[i];
        return res % 1000000n07
reit64_tector<int>ano(nums.size(), 0);
        for (aure r: equestsN
            anur[0]]++;ct
            if (r[1]+1 < count.size()) {
               ano[r[(1]+1]--;);
    }
};
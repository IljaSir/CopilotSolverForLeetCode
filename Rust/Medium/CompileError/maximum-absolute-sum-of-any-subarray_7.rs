impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut cur = 0;
        for n in nums {
            cur += n;
            ans = ans.max(cur);
            cur = cur.max(0);
        }
        let mut ans2 = 0;
        let mut cur2 = 0;
        for n in nums {
            cur2 += n;
            ans2 = ans2.min(cur2);
            cur2 = cur2.min(0);
        }
        ans.max(-ans2)
    }
}
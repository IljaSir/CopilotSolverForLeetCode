impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut cur = 0;
        for i in nums {
            if i == 1 {
                cur += 1;
            } else {
                ans = ans.max(cur);
                cur = 0;
            }
        }
        ans.max(cur)
    }
}
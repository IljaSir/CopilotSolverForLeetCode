impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = 1 << 30;
        while mask > 0 {
            let mut cnt = 0;
            let mut cur = 0;
            for &x in nums.iter() {
                if (x & mask) > 0 {
                    cur += 1;
                } else {
                    cnt = cnt.max(cur);
                    cur = 0;
                }
            }
            cnt = cnt.max(cur);
            if cnt > ans + 1 {
                ans += 1;
            } else {
                ans = cnt;
                break;
            }
            mask >>= 1;
        }
        ans
    }
}
impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let n = nums.len();
        let mut ans = 0;
        for i in 0..n {
            let mut cur = nums[i];
            let mut prev = if i == 0 { 1001 } else { nums[i - 1] };
            let mut next = if i == n - 1 { 1001 } else { nums[i + 1] };
            if i % 2 == 0 {
                if cur <= prev || cur <= next {
                    ans += (prev.min(next) - cur + 1).abs();
                }
            } else {
                if cur >= prev || cur >= next {
                    ans += (prev.max(next) - cur + 1).abs();
                }
            }
        }
        ans
    }
}
impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut a = 0;
        let mut b = 0;
        for i in 0..nums.len() {
            let c = a;
            let d = b;
            a = std::cmp::max(c, d + nums[i] as i64);
            b = std::cmp::max(d, c - nums[i] as i64);
        }
        std::cmp::max(a, b) as i64
    }
}
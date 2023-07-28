impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        let mut res = 0;
        for (i, &v) in nums.iter().enumerate() {
            if i % 2 == 0 {
                even += v;
            } else {
                odd += v;
            }
        }
        let mut left_odd = 0;
        let mut left_even = 0;
        for (i, &v) in nums.iter().enumerate() {
            if i % 2 == 0 {
                even -= v;
                if left_odd + even == left_even + odd {
                    res += 1;
                }
                left_even += v;
            } else {
                odd -= v;
                if left_odd + even == left_even + odd {
                    res += 1;
                }
                left_odd += v;
            }
        }
        res
    }
}
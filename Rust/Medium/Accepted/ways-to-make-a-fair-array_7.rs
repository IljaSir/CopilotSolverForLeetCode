impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut res = 0;
        let mut odd_sum = 0;
        let mut even_sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for i in 0..n {
            if i % 2 == 0 {
                even_sum += nums[i];
            } else {
                odd_sum += nums[i];
            }
        }
        for i in 0..n {
            if i % 2 == 0 {
                even_sum -= nums[i];
            } else {
                odd_sum -= nums[i];
            }
            if odd_sum + even == even_sum + odd {
                res += 1;
            }
            if i % 2 == 0 {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        res
    }
}
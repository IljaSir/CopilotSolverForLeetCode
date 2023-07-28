impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut min = nums[0];
        for i in 1..nums.len() {
            min = gcd(min, nums[i]);
        }
        let mut ans = 0;
        for i in 0..nums_divide.len() {
            if nums_divide[i] % min != 0 {
                ans = -1;
                break;
            } else {
                ans += nums_divide[i] / min - 1;
            }
        }
        ans
    }
}
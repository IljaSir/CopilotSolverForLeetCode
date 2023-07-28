impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if Solution::digit_sum(nums[i]) == Solution::digit_sum(nums[j]) {
                    let sum = nums[i] + nums[j];
                    if sum > max {
                        max = sum;
                    }
                }
            }
        }
        max
    }
    
    pub fn digit_sum(num: i32) -> i32 {
        let mut sum = 0;
        let mut n = num;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum
    }
}
impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if Solution::sum_of_digits(nums[i]) == Solution::sum_of_digits(nums[j]) {
                    let sum = nums[i] + nums[j];
                    if sum > max {
                        max = sum;
                    }
                }
            }
        }
        max
    }
    
    fn sum_of_digits(num: i32) -> i32 {
        let mut sum = 0;
        let mut n = num;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum
    }
}
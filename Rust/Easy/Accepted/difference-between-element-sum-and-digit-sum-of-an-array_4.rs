impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut digit_sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            let mut num = nums[i];
            while num > 0 {
                digit_sum += num % 10;
                num /= 10;
            }
        }
        (sum - digit_sum).abs()
    }
}
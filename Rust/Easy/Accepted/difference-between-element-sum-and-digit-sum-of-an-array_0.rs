impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut element_sum = 0;
        let mut digit_sum = 0;
        for i in 0..nums.len() {
            element_sum += nums[i];
            let mut num = nums[i];
            while num > 0 {
                digit_sum += num % 10;
                num /= 10;
            }
        }
        (element_sum - digit_sum).abs()
    }
}
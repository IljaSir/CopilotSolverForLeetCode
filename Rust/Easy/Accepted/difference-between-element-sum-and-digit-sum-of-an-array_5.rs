impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut digit_sum = 0;
        for i in nums {
            sum += i;
            digit_sum += i.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum::<u32>() as i32;
        }
        (sum - digit_sum).abs()
    }
}
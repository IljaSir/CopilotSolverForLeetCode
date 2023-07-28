impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut digit_sum = 0;
        for num in nums {
            sum += num;
            let mut n = num;
            while n > 0 {
                digit_sum += n % 10;
                n /= 10;
            }
        }
        (sum - digit_sum).abs()
    }
}
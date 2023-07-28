impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut element_sum = 0;
        let mut digit_sum = 0;
        for x in nums {
            element_sum += x;
            digit_sum += x % 10;
            digit_sum += (x / 10) % 10;
            digit_sum += (x / 100) % 10;
            digit_sum += (x / 1000) % 10;
            digit_sum += (x / 10000) % 10;
        }
        element_sum - digit_sum
    }
}
impl Solution {
    pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
        
        let mut element_sum = 0;
        let mut digit_sum = 0;
        for i in nums {
            element_sum += i;
            digit_sum += i.to_string().chars().map(|x| x.to_digit(10).unwrap()).sum::<u32>() as i32;
        }
        return element_sum - digit_sum;
    }
}
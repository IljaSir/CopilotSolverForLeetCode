impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        nums.into_iter().flat_map(|n| {
            let mut n = n;
            let mut digits = Vec::new();
            while n > 0 {
                digits.push(n % 10);
                n /= 10;
            }
            digits.reverse();
            digits
        }).collect()
    }
}
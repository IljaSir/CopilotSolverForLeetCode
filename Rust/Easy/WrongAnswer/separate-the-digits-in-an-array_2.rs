impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for num in nums {
            let mut n = num;
            while n > 0 {
                result.push(n % 10);
                n /= 10;
            }
        }
        result.reverse();
        result
    }
}
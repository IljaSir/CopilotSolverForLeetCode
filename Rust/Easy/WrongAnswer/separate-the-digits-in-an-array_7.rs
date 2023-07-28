impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for num in nums {
            let mut num = num;
            while num > 0 {
                result.push(num % 10);
                num = num / 10;
            }
            result.reverse();
        }
        result
    }
}
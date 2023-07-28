impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for n in nums {
            sum += n;
        }
        let n = nums.len() as i32;
        n * (n + 1) / 2 - sum
    }
}
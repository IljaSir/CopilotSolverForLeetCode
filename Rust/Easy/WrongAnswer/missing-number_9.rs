impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut n = nums.len();
        for num in nums {
            sum += num as i32;
            n -= 1;
        }
        (n as i32) * (n as i32 + 1) / 2 - sum
    }
}
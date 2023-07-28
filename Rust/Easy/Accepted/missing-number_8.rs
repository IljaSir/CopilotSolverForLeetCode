impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let sum = (n * (n + 1)) / 2;
        let mut total = 0;
        for num in nums {
            total += num as usize;
        }
        (sum - total) as i32
    }
}
impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let sum = nums.iter().sum::<i32>();
        let mut left = 0;
        for (i, &n) in nums.iter().enumerate() {
            if left * 2 == sum - n {
                return i as i32;
            }
            left += n;
        }
        -1
    }
}
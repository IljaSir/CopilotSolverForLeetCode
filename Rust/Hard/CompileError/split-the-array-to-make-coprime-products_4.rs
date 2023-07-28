impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut left = vec![1; n];
        let mut right = vec![1; n];
        for i in 0..n {
            left[i] = left[i - 1] * nums[i];
        }
        for i in (0..n - 1).rev() {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for i in 0..n {
            if gcd(left[i], right[i]) == 1 {
                return i as i32;
            }
        }
        -1
    }
}
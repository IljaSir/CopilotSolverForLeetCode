impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut left = vec![0; n + 1];
        let mut right = vec![0; n + 1];
        for i in 1..=n {
            left[i] = gcd(left[i - 1], nums[i - 1]);
            right[n - i] = gcd(right[n - i + 1], nums[n - i]);
        }
        for i in 1..n {
            if gcd(left[i], right[i + 1]) == 1 {
                return i as i32 - 1;
            }
        }
        -1
    }
}
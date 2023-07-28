impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut left = 1;
        let mut right = 1000000;
        while left < right {
            let mid = (left + right) / 2;
            let sum = nums.iter().map(|n| (n + mid - 1) / mid).sum::<i32>();
            if sum > threshold {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}
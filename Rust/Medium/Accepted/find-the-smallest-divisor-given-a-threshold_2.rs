impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let (mut left, mut right) = (1, 1_000_000);
        while left < right {
            let mid = (left + right) / 2;
            let sum: i32 = nums.iter().map(|&x| (x + mid - 1) / mid).sum();
            if sum > threshold {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}
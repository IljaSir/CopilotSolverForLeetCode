impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let (mut left, mut right) = (1, *nums.iter().max().unwrap());
        while left < right {
            let mid = (left + right) / 2;
            let sum = nums.iter().map(|&x| (x + mid - 1) / mid).sum::<i32>();
            if sum > threshold {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}
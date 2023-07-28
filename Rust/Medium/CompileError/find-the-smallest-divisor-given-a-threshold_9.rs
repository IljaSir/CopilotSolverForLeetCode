impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut left = 1;
        let mut right = nums.iter().max().unwrap();
        while left < right {
            let mid = (left + right) / 2;
            let sum = nums.iter().map(|&x| (x as f64 / mid as f64).ceil() as i32).sum::<i32>();
            if sum > threshold {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}
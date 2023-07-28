impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = 1_000_000;
        while l < r {
            let mid = (l + r) / 2;
            let mut sum = 0;
            for n in &nums {
                sum += (n + mid - 1) / mid;
            }
            if sum > threshold {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}
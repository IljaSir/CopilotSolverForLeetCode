impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = 1_000_000;
        while l < r {
            let m = l + (r - l) / 2;
            let sum = nums.iter().map(|&x| (x + m - 1) / m).sum::<i32>();
            if sum > threshold {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
}
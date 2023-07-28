impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let (mut l, mut r) = (1, *nums.iter().max().unwrap());
        while l < r {
            let m = l + (r - l) / 2;
            let sum: i32 = nums.iter().map(|n| (n + m - 1) / m).sum();
            if sum <= threshold {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}
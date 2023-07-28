impl Solution {
    pub fn smallest_divisor(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = *nums.iter().max().unwrap();
        while l < r {
            let m = (l + r) >> 1;
            let sum = nums.iter().map(|x| (x + m - 1) / m).sum::<i32>();
            if sum <= threshold {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}
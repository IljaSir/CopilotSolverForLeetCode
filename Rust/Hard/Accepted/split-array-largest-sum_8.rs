impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut l, mut r) = (0, 0);
        for &v in nums.iter() {
            l = l.max(v);
            r += v;
        }
        while l < r {
            let m = l + (r - l) / 2;
            if Self::check(&nums, k, m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
    fn check(nums: &[i32], k: i32, t: i32) -> bool {
        let mut sum = 0;
        let mut k = k;
        for &v in nums.iter() {
            if sum + v > t {
                k -= 1;
                sum = v;
            } else {
                sum += v;
            }
        }
        k > 0
    }
}
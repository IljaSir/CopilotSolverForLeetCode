impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let (mut l, mut h) = (nums[0], nums[0]);
        for &n in &nums[1..] {
            l = l.min(n);
            h = h.max(n);
        }
        let (mut r, mut s) = (h - l, h - l);
        for i in 1..nums.len() {
            let (a, b) = (nums[i - 1], nums[i]);
            r = r.min((a - l).abs().max((b - h).abs()))
                .min((a - h).abs().max((b - l).abs()));
            s += (a - b).abs();
        }
        s - r
    }
}
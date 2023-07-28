impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        
        let mut l = 0;
        let mut r = k as usize;
        let mut ret = Vec::new();
        let mut nums = nums;
        while r <= nums.len() {
            let mut curr = nums[l..r].to_vec();
            curr.sort();
            if k % 2 == 0 {
                ret.push((curr[(k/2) as usize - 1] + curr[k as usize/2]) as f64 / 2.0);
            } else {
                ret.push(curr[k as usize/2] as f64);
            }
            l += 1;
            r += 1;
        }
        ret
    }
}
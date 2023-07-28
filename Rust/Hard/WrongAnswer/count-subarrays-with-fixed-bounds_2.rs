impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut res = 0;
        let mut l = 0;
        let mut r = 0;
        let mut min = 0;
        let mut max = 0;
        while r < nums.len() {
            if nums[r] >= min_k {
                min = r;
            }
            if nums[r] > max_k {
                max = r;
            }
            if max > min {
                l = max;
            }
            res += l as i64 - min as i64 + 1;
            r += 1;
        }
        res
    }
}
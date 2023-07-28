impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let k = k as usize;
        let n = nums.len();
        let mut res = vec![0; k];
        let mut l = 0;
        let mut r = n - k;
        let mut i = 0;
        let mut j = 0;
        while i < k {
            if nums[l] > nums[r] {
                res[i] = nums[l];
                l += 1;
            } else {
                res[k - j - 1] = nums[r];
                r += 1;
                j += 1;
            }
            i += 1;
        }
        res
    }
}
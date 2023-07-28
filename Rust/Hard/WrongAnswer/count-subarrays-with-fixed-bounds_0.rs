impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let n = nums.len();
        let mut s = vec![0; n + 1];
        for i in 0..n {
            s[i + 1] = s[i] + nums[i];
        }
        let mut res = 0;
        for i in 0..n {
            for j in i..n {
                if s[j + 1] - s[i] >= min_k && s[j + 1] - s[i] <= max_k {
                    res += 1;
                }
            }
        }
        res
    }
}
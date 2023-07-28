impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut s = vec![0; n + 1];
        for i in 0..n {
            s[i + 1] = s[i] + nums[i];
        }
        let mut res = 0;
        for i in 0..n {
            for j in i + 1..n + 1 {
                let m = (s[j] - s[i]) as f64 / (j - i) as f64;
                if m == k as f64 {
                    res += 1;
                }
            }
        }
        res
    }
}
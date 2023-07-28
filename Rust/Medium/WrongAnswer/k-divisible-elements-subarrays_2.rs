impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let n = nums.len();
        let k = k as usize;
        let p = p as usize;
        let mut cnt = vec![0; p];
        let mut s = 0;
        let mut res = 0;
        for i in 0..n {
            s = (s + nums[i] as usize) % p;
            if i >= k {
                cnt[(s - nums[i - k] as usize + p) % p] -= 1;
            }
            res += cnt[s];
            cnt[s] += 1;
        }
        res as i32
    }
}
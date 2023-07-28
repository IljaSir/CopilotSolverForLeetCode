impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut sum = vec![0; n + 1];
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        let mut m = 0;
        let mut modu = 1_000_000007;
        for i in 0..n {
            sum[i + 1] = i] + nums[i];
        }
        for i in 1..n {
            l = i;
            r = n;
            while l < r {
                m = (l + r) / 2;
                if sum[m] - sum[i] >= sum[i] {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if r > i && sum[n] - sum[r] >= sum[r] - sum[i] {
                ans = (ans + (n - r + 1) as i32) % modu;
            }
        }
        ans
    }
}
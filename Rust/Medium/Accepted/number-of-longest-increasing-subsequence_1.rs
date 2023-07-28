impl Solution {
    pub fn find_number_of_lis(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        if n <= 1 {
            return n as i32;
        }
        let mut f = vec![1; n];
        let mut g = vec![1; n];
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    if f[j] + 1 > f[i] {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if f[j] + 1 == f[i] {
                        g[i] += g[j];
                    }
                }
            }
        }
        let max_len = f.iter().max().unwrap();
        let mut ans = 0;
        for i in 0..n {
            if f[i] == *max_len {
                ans += g[i];
            }
        }
        ans
    }
}
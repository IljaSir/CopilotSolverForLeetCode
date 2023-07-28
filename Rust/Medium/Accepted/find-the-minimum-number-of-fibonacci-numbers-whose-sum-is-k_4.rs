impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut f = vec![1, 1];
        let mut i = 2;
        while f[i - 1] + f[i - 2] <= k {
            f.push(f[i - 1] + f[i - 2]);
            i += 1;
        }
        let mut ans = 0;
        let mut k = k;
        for i in (0..f.len()).rev() {
            if k >= f[i] {
                k -= f[i];
                ans += 1;
            }
        }
        ans
    }
}
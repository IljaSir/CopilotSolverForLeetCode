impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut a: Vec<u8> = s.into_bytes();
        let n = a.len();
        let mut cnt = vec![0; 26];
        let mut fac = vec![1; n];
        for i in 1..n {
            fac[i] = fac[i - 1] * i as i32 % 1000000007;
        }
        let mut ans = 0;
        for i in (0..n).rev() {
            let c = a[i] - b'a';
            let mut sum = 0;
            for j in 0..c {
                sum = (sum + cnt[j]) % 1000000007;
            }
            ans = (ans + sum * fac[n - i - 1]) % 1000000007;
            cnt[c] += 1;
        }
        ans
    }
}
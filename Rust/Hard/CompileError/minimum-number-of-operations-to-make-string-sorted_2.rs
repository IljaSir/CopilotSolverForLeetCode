impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut cnt = vec![0; 26];
        let mut ans = 0;
        let mut fac = vec![1; s.len() + 1];
        let mut inv = vec![1; s.len() + 1];
        let mut inv_fac = vec![1; s.len() + 1];
        let mut mod_inv = vec![1; s.len() + 1];
        let mut f = 1;
        for i in 1..=s.len() {
            f = (f * i) % 1000000007;
            fac[i] = f;
            inv[i] = mod_pow(f, 1000000007 - 2, 1000000007);
            inv_fac[i] = (inv_fac[i - 1] * inv[i]) % 1000000007;
            mod_inv[i] = (mod_inv[i - 1] * inv[i]) % 1000000007;
        }
        let mut s = s.into_bytes();
        for i in 0..s.len() {
            for j in 0..s[i] - b'a' {
                ans = (ans + cnt[j as usize] * fac[s.len() - i - 1]) % 1000000007;
            }
            cnt[(s[i] - b'a') as usize] += 1;
        }
        for i in 0..26 {
            ans = (ans * inv_fac[cnt[i]]) % 1000000007;
        }
        ans
    }
}
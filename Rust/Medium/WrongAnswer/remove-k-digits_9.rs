impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut s = num.into_bytes();
        let mut k = k as usize;
        let mut i = 0;
        let mut n = s.len();
        while k > 0 {
            while i < n - 1 && s[i] <= s[i + 1] {
                i += 1;
            }
            for j in i..n - 1 {
                s[j] = s[j + 1];
            }
            n -= 1;
            k -= 1;
            if i > 0 {
                i -= 1;
            }
        }
        while n > 1 && s[0] == b'0' {
            for i in 0..n - 1 {
                s[i] = s[i + 1];
            }
            n -= 1;
        }
        String::from_utf8(s[..n].to_vec()).unwrap()
    }
}
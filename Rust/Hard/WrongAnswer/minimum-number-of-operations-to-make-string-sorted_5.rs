impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut a = vec![0; 26];
        let mut f = vec![1; 3001];
        let mut r = 0;
        for i in 1..3001 {
            f[i] = f[i - 1] * i as i64 % 1000000007;
        }
        for c in s.bytes() {
            a[(c - b'a') as usize] += 1;
        }
        for i in 0..s.len() {
            let mut c = 0;
            for j in 0..26 {
                if a[j] == 0 {
                    continue;
                }
                a[j] -= 1;
                let mut t = f[s.len() - i - 1];
                for k in 0..26 {
                    t = t * f[a[k] as usize] % 1000000007;
                }
                r = (r + t) % 1000000007;
                a[j] += 1;
                if s.as_bytes()[i] == b'a' + j as u8 {
                    break;
                }
                c += 1;
            }
            a[(s.as_bytes()[i] - b'a') as usize] -= 1;
        }
        r as i32
    }
}
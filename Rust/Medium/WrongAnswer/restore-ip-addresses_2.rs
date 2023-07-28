impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut res = vec![];
        let s = s.into_bytes();
        let n = s.len();
        if n < 4 || n > 12 {
            return res;
        }
        for i in 1..4 {
            for j in i+1..i+4 {
                for k in j+1..j+4 {
                    if k >= n {
                        continue;
                    }
                    let a = &s[..i];
                    let b = &s[i..j];
                    let c = &s[j..k];
                    let d = &s[k..];
                    if a.len() > 1 && a[0] == b'0' {
                        continue;
                    }
                    if b.len() > 1 && b[0] == b'0' {
                        continue;
                    }
                    if c.len() > 1 && c[0] == b'0' {
                        continue;
                    }
                    if d.len() > 1 && d[0] == b'0' {
                        continue;
                    }
                    let a: u8 = a.iter().fold(0, |sum, &x| sum * 10 + x - b'0');
                    let b: u8 = b.iter().fold(0, |sum, &x| sum * 10 + x - b'0');
                    let c: u8 = c.iter().fold(0, |sum, &x| sum * 10 + x - b'0');
                    let d: u8 = d.iter().fold(0, |sum, &x| sum * 10 + x - b'0');
                    if a > 255 || b > 255 || c > 255 || d > 255 {
                        continue;
                    }
                    let ip = format!("{}.{}.{}.{}", a, b, c, d);
                    res.push(ip);
                }
            }
        }
        res
    }
}
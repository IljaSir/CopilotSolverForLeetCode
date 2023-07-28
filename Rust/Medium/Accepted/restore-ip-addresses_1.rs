impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut res = Vec::new();
        let s = s.as_bytes();
        for i in 1..4 {
            for j in 1..4 {
                for k in 1..4 {
                    for l in 1..4 {
                        if i + j + k + l == s.len() {
                            if let (Ok(a), Ok(b), Ok(c), Ok(d)) = (std::str::from_utf8(&s[..i]).unwrap().parse::<u8>(), std::str::from_utf8(&s[i..i+j]).unwrap().parse::<u8>(), std::str::from_utf8(&s[i+j..i+j+k]).unwrap().parse::<u8>(), std::str::from_utf8(&s[i+j+k..]).unwrap().parse::<u8>()) {
                                if a <= 255 && b <= 255 && c <= 255 && d <= 255 {
                                    let ip = format!("{}.{}.{}.{}", a, b, c, d);
                                    if ip.len() == s.len() + 3 {
                                        res.push(ip);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        res
    }
}
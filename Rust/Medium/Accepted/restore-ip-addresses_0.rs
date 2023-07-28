impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut ret = vec![];
        let s = s.as_bytes();
        for a in 1..4 {
            for b in 1..4 {
                for c in 1..4 {
                    for d in 1..4 {
                        if a + b + c + d == s.len() {
                            let mut n1 = 0;
                            for i in 0..a {
                                n1 = n1 * 10 + (s[i] - b'0') as i32;
                            }
                            let mut n2 = 0;
                            for i in a..a + b {
                                n2 = n2 * 10 + (s[i] - b'0') as i32;
                            }
                            let mut n3 = 0;
                            for i in a + b..a + b + c {
                                n3 = n3 * 10 + (s[i] - b'0') as i32;
                            }
                            let mut n4 = 0;
                            for i in a + b + c..a + b + c + d {
                                n4 = n4 * 10 + (s[i] - b'0') as i32;
                            }
                            if n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255 {
                                let mut ip = vec![n1, n2, n3, n4];
                                let mut ip_str = vec![];
                                for i in 0..ip.len() {
                                    ip_str.push(ip[i].to_string());
                                }
                                let ip_str = ip_str.join(".");
                                if ip_str.len() == s.len() + 3 {
                                    ret.push(ip_str);
                                }
                            }
                        }
                    }
                }
            }
        }
        ret
    }
}
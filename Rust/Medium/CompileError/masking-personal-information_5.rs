impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut res = String::new();
            let mut i = 0;
            while i < s.len() {
                if s.as_bytes()[i] == '@' as u8 {
                    break;
                }
                if s.as_bytes()[i] >= 'A' as u8 && s.as_bytes()[i] <= 'Z' as u8 {
                    res.push((s.as_bytes()[i] - 'A' as u8 + 'a' as u8) as char);
                } else {
                    res.push(s.as_bytes()[i] as char);
                }
                i += 1;
            }
            res.push('@');
            i += 1;
            while i < s.len() {
                if s.as_bytes()[i] >= 'A' as u8 && s.as_bytes()[i] <= 'Z' as u8 {
                    res.push((s.as_bytes()[i] - 'A' as u8 + 'a' as u8) as char);
                } else {
                    res.push(s.as_bytes()[i] as char);
                }
                i += 1;
            }
            res
        } else {
            let mut res = String::new();
            let mut i = 0;
            while i < s.len() {
                if s.as_bytes()[i] >= '0' as u8 && s.as_bytes()[i] <= '9' as u8 {
                    res.push(s.as_bytes()[i] as char);
                }
                i += 1;
            }
            let len = res.len();
            if len == 10 {
                res.insert(0, '-');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '-');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '-');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '*');
            } else if len == 11 {
                res.insert(0, '-');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '*');
                res.insert(0, '-');
                res.insert(0, '*');
                res.insert(0, '*');
    }
}
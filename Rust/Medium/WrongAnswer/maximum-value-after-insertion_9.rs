impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut x = x as u8 - '0' as u8;
        let mut chars = n.chars();
        let mut res = String::new();
        let mut neg = false;
        let mut inserted = false;
        if let Some(c) = chars.next() {
            if c == '-' {
                neg = true;
                res.push(c);
            } else {
                res.push(c);
            }
        }
        if neg {
            while let Some(c) = chars.next() {
                let c = c as u8 - '0' as u8;
                if c <= x {
                    res.push((c + '0' as u8) as char);
                } else {
                    res.push((x + '0' as u8) as char);
                    res.push((c + '0' as u8) as char);
                    inserted = true;
                    break;
                }
            }
        } else {
            while let Some(c) = chars.next() {
                let c = c as u8 - '0' as u8;
                if c >= x {
                    res.push((c + '0' as u8) as char);
                } else {
                    res.push((x + '0' as u8) as char);
                    res.push((c + '0' as u8) as char);
                    inserted = true;
                    break;
                }
            }
        }
        if !inserted {
            res.push((x + '0' as u8) as char);
        }
        res
    }
}
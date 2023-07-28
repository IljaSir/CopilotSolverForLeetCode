impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let (a, b) = if a.len() > b.len() { (a, b) } else { (b, a) };
        let mut a = a.chars().rev();
        let mut b = b.chars().rev();
        let mut c = 0;
        let mut res = String::new();
        loop {
            match (a.next(), b.next()) {
                (Some('1'), Some('1')) => {
                    res.push(if c == 0 { '0' } else { '1' });
                    c = 1;
                }
                (Some('1'), Some('0')) | (Some('0'), Some('1')) => {
                    res.push(if c == 0 { '1' } else { '0' });
                }
                (Some('1'), None) | (Some('0'), None) => {
                    res.push(if c == 0 { '1' } else { '0' });
                    c = if c == 0 { 0 } else { 1 };
                }
                (None, None) => {
                    if c == 1 {
                        res.push('1');
                    }
                    break;
                }
                _ => unreachable!(),
            }
        }
        res.chars().rev().collect()
    }
}
impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s;
        let mut v = s.as_bytes().to_vec();
        v.sort();
        s = String::from_utf8(v).unwrap();
        let mut result = String::new();
        loop {
            let mut last = ' ';
            let mut i = 0;
            while i < s.len() {
                let c = s.chars().nth(i).unwrap();
                if c != last {
                    result.push(c);
                    last = c;
                    s.remove(i);
                } else {
                    i += 1;
                }
            }
            if s.is_empty() {
                break;
            }
            last = ' ';
            i = s.len() - 1;
            while i < s.len() {
                let c = s.chars().nth(i).unwrap();
                if c != last {
                    result.push(c);
                    last = c;
                    s.remove(i);
                } else {
                    i -= 1;
                }
            }
            if s.is_empty() {
                break;
            }
        }
        result
    }
}
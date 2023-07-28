impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut result = String::new();
        let mut prev = 'a';
        let mut next = 'a';
        for (i, c) in s.chars().enumerate() {
            if c == '?' {
                if i == 0 {
                    if i + 1 < s.len() {
                        next = s.chars().nth(i + 1).unwrap();
                    }
                    while prev == next {
                        next = ((next as u8) + 1) as char;
                    }
                    result.push(next);
                    prev = next;
                } else {
                    if i + 1 < s.len() {
                        next = s.chars().nth(i + 1).unwrap();
                    }
                    while prev == next || prev == c {
                        next = ((next as u8) + 1) as char;
                    }
                    result.push(next);
                    prev = next;
                }
            } else {
                result.push(c);
                prev = c;
            }
        }
        result
    }
}
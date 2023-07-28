impl Solution {
    pub fn repeat_limited_string(s: String, repeat_limit: i32) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        let mut c = s.chars().nth(0).unwrap();
        while i < s.len() {
            if s.chars().nth(i).unwrap() == c {
                count += 1;
                if count == repeat_limit {
                    res.push(c);
                    count = 0;
                    j = i + 1;
                }
            } else {
                for _ in 0..count {
                    res.push(c);
                }
                c = s.chars().nth(i).unwrap();
                count = 1;
            }
            i += 1;
        }
        for _ in 0..count {
            res.push(c);
        }
        res
    }
}
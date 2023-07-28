impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut v = vec![];
        for c in s.chars() {
            if c.is_digit(10) {
                v.push(c.to_digit(10).unwrap());
            }
        }
        v.sort();
        v.dedup();
        if v.len() > 1 {
            return v[v.len() - 2] as i32;
        } else {
            return -1;
        }
    }
}
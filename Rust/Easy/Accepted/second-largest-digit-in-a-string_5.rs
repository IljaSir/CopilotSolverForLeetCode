impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut v = vec![];
        for c in s.chars() {
            if c.is_digit(10) {
                v.push(c.to_digit(10).unwrap());
            }
        }
        if v.len() == 0 {
            return -1;
        }
        v.sort();
        v.dedup();
        if v.len() < 2 {
            return -1;
        }
        v[v.len() - 2] as i32
    }
}
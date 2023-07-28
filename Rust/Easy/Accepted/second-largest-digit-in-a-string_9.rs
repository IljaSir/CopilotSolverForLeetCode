impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut v = vec![];
        for c in s.chars() {
            if c.is_numeric() {
                v.push(c as i32 - '0' as i32);
            }
        }
        v.sort();
        v.dedup();
        if v.len() > 1 {
            v[v.len() - 2]
        } else {
            -1
        }
    }
}
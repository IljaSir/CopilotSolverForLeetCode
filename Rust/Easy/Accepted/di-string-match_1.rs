impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut res = vec![];
        let mut min = 0;
        let mut max = s.len() as i32;
        for c in s.chars() {
            if c == 'I' {
                res.push(min);
                min += 1;
            } else {
                res.push(max);
                max -= 1;
            }
        }
        res.push(min);
        res
    }
}
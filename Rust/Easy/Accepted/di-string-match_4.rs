impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut v: Vec<i32> = Vec::new();
        let mut min = 0;
        let mut max = s.len() as i32;
        for c in s.chars() {
            if c == 'I' {
                v.push(min);
                min += 1;
            } else {
                v.push(max);
                max -= 1;
            }
        }
        v.push(min);
        v
    }
}
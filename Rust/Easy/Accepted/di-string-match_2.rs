impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut max = s.len() as i32;
        let mut min = 0;
        for c in s.chars() {
            if c == 'I' {
                result.push(min);
                min += 1;
            } else {
                result.push(max);
                max -= 1;
            }
        }
        result.push(max);
        result
    }
}
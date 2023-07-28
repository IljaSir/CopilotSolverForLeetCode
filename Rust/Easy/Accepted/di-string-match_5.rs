impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut ret = Vec::new();
        let mut max = s.len() as i32;
        let mut min = 0;
        for c in s.chars() {
            match c {
                'I' => {
                    ret.push(min);
                    min += 1;
                }
                'D' => {
                    ret.push(max);
                    max -= 1;
                }
                _ => {}
            }
        }
        ret.push(min);
        ret
    }
}
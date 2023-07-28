impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        let mut min = 0;
        let mut max = s.len() as i32;
        for c in s.chars() {
            match c {
                'I' => {
                    res.push(min);
                    min += 1;
                }
                'D' => {
                    res.push(max);
                    max -= 1;
                }
                _ => {}
            }
        }
        res.push(max);
        res
    }
}
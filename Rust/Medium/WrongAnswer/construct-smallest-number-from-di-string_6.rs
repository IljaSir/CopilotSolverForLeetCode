impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut res = String::new();
        let mut min = 1;
        let mut max = 9;
        for c in pattern.chars() {
            match c {
                'I' => {
                    res.push(min.to_string().chars().next().unwrap());
                    min += 1;
                }
                'D' => {
                    res.push(max.to_string().chars().next().unwrap());
                    max -= 1;
                }
                _ => {}
            }
        }
        res.push(max.to_string().chars().next().unwrap());
        res
    }
}
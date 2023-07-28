impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut start = 0;
        let mut end = 0;
        let mut prev = s.chars().nth(0).unwrap();
        for (i, c) in s.chars().enumerate() {
            if c == prev {
                end = i as i32;
            } else {
                if end - start >= 2 {
                    result.push(vec![start, end]);
                }
                start = i as i32;
                end = i as i32;
            }
            prev = c;
        }
        if end - start >= 2 {
            result.push(vec![start, end]);
        }
        result
    }
}
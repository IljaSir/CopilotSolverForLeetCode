impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut start = 0;
        let mut end = 0;
        let mut prev = s.chars().next().unwrap();
        for (i, c) in s.chars().enumerate() {
            if c == prev {
                end += 1;
            } else {
                if end - start >= 2 {
                    result.push(vec![start as i32, end as i32 - 1]);
                }
                start = i;
                end = i + 1;
                prev = c;
            }
        }
        if end - start >= 2 {
            result.push(vec![start as i32, end as i32 - 1]);
        }
        result
    }
}
impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let s = s.as_bytes();
        let mut result = vec![];
        let mut start = 0;
        let mut end = 0;
        for i in 1..s.len() {
            if s[i] == s[i - 1] {
                end += 1;
            } else {
                if end - start >= 2 {
                    result.push(vec![start as i32, end as i32]);
                }
                start = i;
                end = i;
            }
        }
        if end - start >= 2 {
            result.push(vec![start as i32, end as i32]);
        }
        result
    }
}
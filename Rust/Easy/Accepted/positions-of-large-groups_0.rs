impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut start = 0;
        let mut end = 0;
        for i in 1..s.len() {
            if s.as_bytes()[i] == s.as_bytes()[i-1] {
                end += 1;
            } else {
                if end - start >= 2 {
                    res.push(vec![start as i32, end as i32]);
                }
                start = i;
                end = i;
            }
        }
        if end - start >= 2 {
            res.push(vec![start as i32, end as i32]);
        }
        res
    }
}
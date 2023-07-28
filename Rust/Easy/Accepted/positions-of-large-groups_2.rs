impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let (mut start, mut end) = (0, 0);
        for i in 1..s.len() {
            if s.as_bytes()[i] == s.as_bytes()[i-1] {
                end = i as i32;
            } else {
                if end - start >= 2 {
                    res.push(vec![start, end]);
                }
                start = i as i32;
                end = i as i32;
            }
        }
        if end - start >= 2 {
            res.push(vec![start, end]);
        }
        res
    }
}
impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut start = 0;
        let mut end = 0;
        let mut pre = ' ';
        for (i, c) in s.chars().enumerate() {
            if c == pre {
                end = i as i32;
            } else {
                if end - start >= 2 {
                    res.push(vec![start, end]);
                }
                start = i as i32;
                end = i as i32;
            }
            pre = c;
        }
        if end - start >= 2 {
            res.push(vec![start, end]);
        }
        res
    }
}
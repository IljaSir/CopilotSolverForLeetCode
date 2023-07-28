impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut ret = Vec::new();
        let mut start = 0;
        let mut end = 0;
        let mut prev = ' ';
        let mut count = 0;
        for c in s.chars() {
            if c != prev {
                if count >= 3 {
                    ret.push(vec![start, end]);
                }
                start = end;
                count = 0;
            }
            count += 1;
            end += 1;
            prev = c;
        }
        if count >= 3 {
            ret.push(vec![start, end]);
        }
        ret
    }
}
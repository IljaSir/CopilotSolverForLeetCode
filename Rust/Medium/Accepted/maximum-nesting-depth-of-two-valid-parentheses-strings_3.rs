impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        
        let mut res = vec![];
        let mut d = 0;
        for c in seq.chars() {
            if c == '(' {
                d += 1;
                res.push(d % 2);
            } else {
                res.push(d % 2);
                d -= 1;
            }
        }
        res
    }
}
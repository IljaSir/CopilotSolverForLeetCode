impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut d = 0;
        for c in seq.chars() {
            if c == '(' {
                d += 1;
                ans.push(d & 1);
            } else {
                ans.push(d & 1);
                d -= 1;
            }
        }
        ans
    }
}
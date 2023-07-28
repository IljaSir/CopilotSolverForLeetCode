impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        
        let mut ans = vec![0; seq.len()];
        let mut d = 0;
        for (i, c) in seq.chars().enumerate() {
            if c == '(' {
                d += 1;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d -= 1;
            }
        }
        ans
    }
}
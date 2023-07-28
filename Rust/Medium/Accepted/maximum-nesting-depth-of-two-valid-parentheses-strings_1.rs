impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        
        let mut depth = 0;
        let mut ans = vec![];
        for c in seq.chars() {
            if c == '(' {
                depth += 1;
                ans.push(depth % 2);
            } else {
                ans.push(depth % 2);
                depth -= 1;
            }
        }
        ans
    }
}
impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        
        let mut ans = 0;
        for s in logs {
            if s == "../" {
                ans = ans.max(0) - 1;
            } else if s != "./" {
                ans += 1;
            }
        }
        ans
    }
}
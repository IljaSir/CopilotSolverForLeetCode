impl Solution {
    pub fn split_string(s: String) -> bool {
        
        fn dfs(s: &str, prev: i64) -> bool {
            if s.is_empty() {
                return true;
            }
            for i in 1..=s.len() {
                let curr = s[..i].parse::<i64>().unwrap();
                if curr == prev - 1 && dfs(&s[i..], curr) {
                    return true;
                }
            }
            false
        }
        dfs(&s, 10_000_000_000)
    }
}
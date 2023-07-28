impl Solution {
    pub fn split_string(s: String) -> bool {
        
        use std::str::FromStr;
        let mut s: Vec<u8> = s.bytes().collect();
        let mut n = s.len();
        let mut res = false;
        let mut dfs = |i: usize, prev: i32| {
            if i == n {
                res = true;
                return;
            }
            let mut cur = 0;
            for j in i..n {
                cur = cur * 10 + (s[j] - b'0') as i32;
                if cur == prev - 1 {
                    dfs(j + 1, cur);
                }
            }
        };
        dfs(0, i32::MAX);
        res
    }
}
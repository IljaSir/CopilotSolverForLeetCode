impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut n = s.len();
        let mut res = false;
        let mut dfs = |i: usize, last: i32| {
            if res {
                return;
            }
            if i == n {
                res = true;
                return;
            }
            let mut x = 0;
            for j in i..n {
                x = x * 10 + (s[j] as i32 - '0' as i32);
                if x == last - 1 {
                    dfs(j + 1, x);
                }
            }
        };
        dfs(0, std::i32::MAX);
        res
    }
}
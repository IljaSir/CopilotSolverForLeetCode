impl Solution {
    pub fn max_unique_split(s: String) -> i32 {
        
        let mut visited = vec![false; 16];
        let mut ans = 0;
        Self::split(&s, &mut visited, 0, &mut ans);
        ans
    }
    fn split(s: &str, visited: &mut Vec<bool>, start: usize, ans: &mut i32) {
        if start == s.len() {
            *ans += 1;
        }
        for i in start..s.len() {
            if visited[i] {
                continue;
            }
            let mut unique = true;
            for j in start..i {
                if s.as_bytes()[j] == s.as_bytes()[i] {
                    unique = false;
                    break;
                }
            }
            if !unique {
                continue;
            }
            visited[i] = true;
            Self::split(s, visited, i + 1, ans);
            visited[i] = false;
        }
    }
}
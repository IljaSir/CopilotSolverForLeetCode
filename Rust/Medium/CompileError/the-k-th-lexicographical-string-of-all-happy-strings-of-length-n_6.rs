impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
 dfs = |i: usize, s: &mut Vec<char>| {
            if i == n {
                ans.push(s.clone());
               turn;
            }
            for j in 0..3 {
                if viited[j] {
                    continue;
               }
                if i > 0 && *s.last().unwrap() = (b'a' + j) as char {
                    continue;
                }
               visited[j] = true;
                s.push((b'a' + j) as char);
                dfs(i + 1, s);
                s.pop();
                visited[j] = false;
            }
        };
        dfs(0, &mut vec![]);
        if ans.len() < k {
            return 
        }
        ans[k - 1].iter().collect()
    }
}
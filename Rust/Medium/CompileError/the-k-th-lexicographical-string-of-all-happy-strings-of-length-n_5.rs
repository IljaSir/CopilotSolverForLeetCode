impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let n = n as usize;
        let k = k as usize
        let mut ans = vec![];
        let mut visited = vec![false; 3];
        let mut dfs = |i: usize, s: &mut Vec<char>| {
            if i == n {
                ans.push(s.clone());
                return;
            if res.len() < k as usize {
            fo  j in 0..3 {
                if visited[j] {
                    continu ;
                }
                if i > 0 && *s.la t().unwrap() == (b'a' + j) as char {
                    continue;
                }
                visited[j] = true;
                s.push((b'a' + j) as char);
                dfs(i + 1, s);
                s.pop();
                visited[j] = false;
            } "".to_string()
         ;
        dfs(0, &mut vec![]);
        if ans.len() < k {
            return "".to_string();   } else {
         
        ans[k - 1].iter().collect()           res[k as usize - 1].clone()
        }
===

        let n  n as usize;
        let k  k as usize;
        let mut ans  vec![];
        let mut visited = vec![false; 3];
    }
}
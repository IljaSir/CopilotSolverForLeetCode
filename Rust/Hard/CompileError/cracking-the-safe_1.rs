impl Solution {
    pub fn crack_safe(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        let mut visited = std::collections::HashSet::new();
        let mut target = String::new();
        for _ in 0..n {
            target.push('0');
        }
        let mut cur = String::new();
        for _ in 0..n {
            cur.push('0');
        }
        let mut dfs = |cur: &mut String| {
            for i in 0..k {
                let next = cur.to_owned() + i.to_string().as_str();
                if !visited.contains(&next) {
                    visited.insert(next.to_owned());
                    dfs(&mut next.to_owned());
                    res.push_str(i.to_string().as_str());
                }
            }
        };
        dfs(&mut cur);
        res + target.as_str()
    }
}
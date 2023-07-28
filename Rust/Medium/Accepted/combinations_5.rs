impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut cur = vec![];
        Self::dfs(&mut res, &mut cur, n, k, 1);
        res
    }
    
    pub fn dfs(res: &mut Vec<Vec<i32>>, cur: &mut Vec<i32>, n: i32, k: i32, start: i32) {
        if cur.len() == k as usize {
            res.push(cur.clone());
            return;
        }
        for i in start..=n {
            cur.push(i);
            Self::dfs(res, cur, n, k, i+1);
            cur.pop();
        }
    }
}
impl Solution {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        
        let mut ans = 0;
        let mut edges = vec![vec![]; n as usize];
        for r in roads {
            edges[r[0] as usize].push(r[1] as usize);
            edges[r[1] as usize].push(r[0] as usize);
        }
        for i in 0..n {
            let mut visited = vec![false; n as usize];
            let mut stack = vec![i as usize];
            let mut sum = 0;
            while let Some(u) = stack.pop() {
                visited[u] = true;
                sum += 1;
                for &v in &edges[u] {
                    if !visited[v] {
                        stack.push(v);
                    }
                }
            }
            ans = ans.max(sum);
        }
        ans as i64
    }
}
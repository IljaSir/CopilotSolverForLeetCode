impl Solution {
    pub fn garden_no_adj(n: i32, paths: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut g = vec![vec![]; n as usize];
        for p in paths {
            g[p[0] as usize - 1].push(p[1] as usize - 1);
            g[p[1] as usize - 1].push(p[0] as usize - 1);
        }
        let mut ans = vec![0; n as usize];
        for i in 0..n as usize {
            let mut used = [false; 5];
            for &j in &g[i] {
                used[ans[j] as usize] = true;
            }
            for c in 1..=4 {
                if !used[c] {
                    ans[i] = c as i32;
                    break;
                }
            }
        }
        ans
    }
}
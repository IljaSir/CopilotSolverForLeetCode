impl Solution {
    pub fn swim_in_water(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut parent = vec![0; n * n];
        for i in 0..n * n {
            parent[i] = i;
        }
        let mut edges = vec![];
        for i in 0..n {
            for j in 0..n {
                let idx = i * n + j;
                if i > 0 {
                    edges.push((idx - n, idx, grid[i][j].max(grid[i - 1][j])));
                }
                if j > 0 {
                    edges.push((idx - 1, idx, grid[i][j].max(grid[i][j - 1])));
                }
            }
        }
        edges.sort_by(|a, b| a.2.cmp(&b.2));
        let mut res = 0;
        for (u, v, w) in edges {
            if !Solution::union(&mut parent, u, v) {
                continue;
            }
            res = w;
            if Solution::find(&mut parent, 0) == Solution::find(&mut parent, n * n - 1) {
                break;
            }
        }
        res
    }
    fn find(parent: &mut Vec<usize>, x: usize) -> usize {
        if parent[x] != x {
            parent[x] = Solution::find(parent, parent[x]);
        }
        parent[x]
    }
    fn union(parent: &mut Vec<usize>, x: usize, y: usize) -> bool {
        let fx = Solution::find(parent, x);
        let fy = Solution::find(parent, y);
        if fx == fy {
            return false;
        }
        parent[fx] = fy;
        true
    }
}
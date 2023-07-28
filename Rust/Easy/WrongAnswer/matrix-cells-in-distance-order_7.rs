impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut dist = vec![vec![0;cols as usize];rows as usize];
        for i in 0..rows {
            for j in 0..cols {
                dist[i as usize][j as usize] = (i-r_center).abs() + (j-c_center).abs();
            }
        }
        let mut dists = vec![];
        for i in 0..rows {
            for j in 0..cols {
                dists.push(dist[i as usize][j as usize]);
            }
        }
        dists.sort();
        for i in 0..rows {
            for j in 0..cols {
                if dist[i as usize][j as usize] == dists[0] {
                    ans.push(vec![i,j]);
                    dists.remove(0);
                }
            }
        }
        ans
    }
}
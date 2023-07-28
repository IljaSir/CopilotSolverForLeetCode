impl Solution {
    pub fn champagne_tower(poured: i32, query_row: i32, query_glass: i32) -> f64 {
        
        let mut tower = vec![vec![0.0; 101]; 101];
        tower[0][0] = poured as f64;
        for i in 0..query_row {
            for j in 0..=i {
                let q = (tower[i as usize][j as usize] - 1.0) / 2.0;
                if q > 0.0 {
                    tower[i as usize + 1][j as usize] += q;
                    tower[i as usize + 1][j as usize + 1] += q;
                }
            }
        }
        if tower[query_row as usize][query_glass as usize] > 1.0 {
            1.0
        } else {
            tower[query_row as usize][query_glass as usize]
        }
    }
}
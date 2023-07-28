impl Solution {
    pub fn champagne_tower(poured: i32, query_row: i32, query_glass: i32) -> f64 {
        
        let mut tower = vec![vec![0.0; 100]; 100];
        tower[0][0] = poured as f64;
        for i in 0..query_row as usize {
            for j in 0..=i {
                if tower[i][j] > 1.0 {
                    let overflow = (tower[i][j] - 1.0) / 2.0;
                    tower[i + 1][j] += overflow;
                    tower[i + 1][j + 1] += overflow;
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
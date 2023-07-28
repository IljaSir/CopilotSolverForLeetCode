impl Solution {
    pub fn champagne_tower(poured: i32, query_row: i32, query_glass: i32) -> f64 {
        
        let mut glasses = vec![vec![0.0; 101]; 101];
        glasses[0][0] = poured as f64;
        for i in 0..100 {
            for j in 0..=i {
                let q = (glasses[i][j] - 1.0) / 2.0;
                if q > 0.0 {
                    glasses[i+1][j] += q;
                    glasses[i+1][j+1] += q;
                }
            }
        }
        if glasses[query_row as usize][query_glass as usize] > 1.0 {
            1.0
        } else {
            glasses[query_row as usize][query_glass as usize]
        }
    }
}
impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut row = vec![0; m as usize];
        let mut col = vec![0; n as usize];
        for i in 0..indices.len() {
            let r = indices[i][0] as usize;
            let c = indices[i][1] as usize;
            row[r] += 1;
            col[c] += 1;
        }
        let mut odd = 0;
        for i in 0..m {
            for j in 0..n {
                let r = row[i as usize];
                let c = col[j as usize];
                if (r + c) & 1 == 1 {
                    odd += 1;
                }
            }
        }
        odd
    }
}
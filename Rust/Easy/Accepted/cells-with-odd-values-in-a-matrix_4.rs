impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut matrix = vec![vec![0; n as usize]; m as usize];
        for i in 0..indices.len() {
            let ri = indices[i][0] as usize;
            let ci = indices[i][1] as usize;
            for j in 0..n as usize {
                matrix[ri][j] += 1;
            }
            for j in 0..m as usize {
                matrix[j][ci] += 1;
            }
        }
        let mut res = 0;
        for i in 0..m as usize {
            for j in 0..n as usize {
                if matrix[i][j] % 2 == 1 {
                    res += 1;
                }
            }
        }
        res
    }
}
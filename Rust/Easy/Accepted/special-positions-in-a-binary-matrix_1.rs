impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut row = vec![0; mat.len()];
        let mut col = vec![0; mat[0].len()];
        for i in 0..mat.len() {
            for j in 0..mat[0].len() {
                if mat[i][j] == 1 {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        let mut res = 0;
        for i in 0..mat.len() {
            for j in 0..mat[0].len() {
                if mat[i][j] == 1 && row[i] == 1 && col[j] == 1 {
                    res += 1;
                }
            }
        }
        res
    }
}
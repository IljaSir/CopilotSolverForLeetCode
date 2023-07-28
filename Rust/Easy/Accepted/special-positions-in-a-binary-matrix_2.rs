impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut rows = vec![0; mat.len()];
        let mut cols = vec![0; mat[0].len()];
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 {
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }
        let mut ret = 0;
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1 {
                    ret += 1;
                }
            }
        }
        ret
    }
}
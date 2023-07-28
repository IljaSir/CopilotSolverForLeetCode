impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let rows = mat.len();
        let columns = mat[0].len();
        let mut v = Vec::new();
        if rows * columns == (r * c) as usize {
            for i in 0..rows {
                for j in 0..columns {
                    v.push(mat[i][j]);
                }
            }
            v.chunks(c as usize).map(|x| x.to_vec()).collect()
        } else {
            mat
        }
    }
}
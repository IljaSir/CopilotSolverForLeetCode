impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let (m, n) = (mat.len(), mat[0].len());
        if m * n != (r * c) as usize {
            return mat;
        }
        let mut mat = mat.into_iter().flatten().collect::<Vec<_>>();
        let mut res = vec![vec![0; c as usize]; r as usize];
        for i in 0..r {
            for j in 0..c {
                res[i as usize][j as usize] = mat.remove(0);
            }
        }
        res
    }
}
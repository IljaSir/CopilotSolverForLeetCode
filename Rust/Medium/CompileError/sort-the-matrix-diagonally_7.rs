impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        let (m, n) = (mat.len(), mat[0].len());
        let mut diag = vec![];
        for i in 0..m {
            diag.clear();
            let mut (i, j) = (i, 0);
            while i < m && j < n {
                diag.push(mat[i][j]);
                i += 1;
                j += 1;
            }
            diag.sort();
            let mut (i, j) = (i, j);
            for k in diag {
                i -= 1;
                j -= 1;
                mat[i][j] = k;
            }
        }
        for j in 1..n {
            diag.clear();
            let mut (i, j) = (0, j);
            while i < m && j < n {
                diag.push(mat[i][j]);
                i += 1;
                j += 1;
            }
            diag.sort();
            let mut (i, j) = (i, j);
            for k in diag {
                i -= 1;
                j -= 1;
                mat[i][j] = k;
            }
        }
        mat
    }
}
impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        let m = mat.len();
        let n = mat[0].len();
        for i in 0..m {
            let mut j = 0;
            let mut k = i;
            let mut v = Vec::new();
            while k < m && j < n {
                v.push(mat[k][j]);
                k += 1;
                j += 1;
            }
            v.sort();
            k = i;
            j = 0;
            while k < m && j < n {
                mat[k][j] = v.remove(0);
                k += 1;
                j += 1;
            }
        }
        for j in 1..n {
            let mut i = 0;
            let mut k = j;
            let mut v = Vec::new();
            while k < n && i < m {
                v.push(mat[i][k]);
                k += 1;
                i += 1;
            }
            v.sort();
            k = j;
            i = 0;
            while k < n && i < m {
                mat[i][k] = v.remove(0);
                k += 1;
                i += 1;
            }
        }
        mat
    }
}
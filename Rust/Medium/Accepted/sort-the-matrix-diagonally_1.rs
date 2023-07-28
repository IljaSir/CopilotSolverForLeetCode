impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let m = mat.len();
        let n = mat[0].len();
        let mut mat = mat;
        for i in 0..m {
            let mut j = 0;
            let mut k = i;
            let mut temp: Vec<i32> = vec![];
            while k < m && j < n {
                temp.push(mat[k][j]);
                k += 1;
                j += 1;
            }
            temp.sort();
            k = i;
            j = 0;
            while k < m && j < n {
                mat[k][j] = temp[k - i];
                k += 1;
                j += 1;
            }
        }
        for j in 1..n {
            let mut i = 0;
            let mut k = j;
            let mut temp: Vec<i32> = vec![];
            while k < n && i < m {
                temp.push(mat[i][k]);
                k += 1;
                i += 1;
            }
            temp.sort();
            k = j;
            i = 0;
            while k < n && i < m {
                mat[i][k] = temp[i];
                k += 1;
                i += 1;
            }
        }
        mat
    }
}
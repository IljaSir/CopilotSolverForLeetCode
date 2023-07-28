impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        let m = mat.len();
        let n = mat[0].len();
        let mut v = vec![];
        for i in 0..m {
            let mut j = i;
            let mut k = 0;
            while j < m && k < n {
                v.push(mat[j][k]);
                j += 1;
                k += 1;
            }
            v.sort();
            j = i;
            k = 0;
            while j < m && k < n {
                mat[j][k] = v.remove(0);
                j += 1;
                k += 1;
            }
        }
        for i in 1..n {
            let mut j = 0;
            let mut k = i;
            while j < m && k < n {
                v.push(mat[j][k]);
                j += 1;
                k += 1;
            }
            v.sort();
            j = 0;
            k = i;
            while j < m && k < n {
                mat[j][k] = v.remove(0);
                j += 1;
                k += 1;
            }
        }
        mat
    }
}
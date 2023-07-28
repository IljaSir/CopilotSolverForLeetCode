impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        for i in 0..mat.len() {
            let mut j = i;
            let mut k = 0;
            let mut v = Vec::new();
            while j < mat.len() && k < mat[0].len() {
                v.push(mat[j][k]);
                j += 1;
                k += 1;
            }
            v.sort();
            j = i;
            k = 0;
            while j < mat.len() && k < mat[0].len() {
                mat[j][k] = v.remove(0);
                j += 1;
                k += 1;
            }
        }
        for i in 1..mat[0].len() {
            let mut j = 0;
            let mut k = i;
            let mut v = Vec::new();
            while j < mat.len() && k < mat[0].len() {
                v.push(mat[j][k]);
                j += 1;
                k += 1;
            }
            v.sort();
            j = 0;
            k = i;
            while j < mat.len() && k < mat[0].len() {
                mat[j][k] = v.remove(0);
                j += 1;
                k += 1;
            }
        }
        mat
    }
}
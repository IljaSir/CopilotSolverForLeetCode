impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let (m, n) = (mat.len(), mat[0].len());
        let mut mat = mat;
        for i in 0..m {
            let mut v = Vec::new();
            let mut (x, y) = (i, 0);
            while x < m && y < n {
                v.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            v.sort();
            let mut (x, y) = (i, 0);
            while x < m && y < n {
                mat[x][y] = v.remove(0);
                x += 1;
                y += 1;
            }
        }
        for j in 1..n {
            let mut v = Vec::new();
            let mut (x, y) = (0, j);
            while x < m && y < n {
                v.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            v.sort();
            let mut (x, y) = (0, j);
            while x < m && y < n {
                mat[x][y] = v.remove(0);
                x += 1;
                y += 1;
            }
        }
        mat
    }
}
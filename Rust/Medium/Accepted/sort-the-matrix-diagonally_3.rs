impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        let m = mat.len();
        let n = mat[0].len();
        for i in 0..m {
            let mut vec: Vec<i32> = vec![];
            let mut x = i;
            let mut y = 0;
            while x < m && y < n {
                vec.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            vec.sort();
            x = i;
            y = 0;
            for j in 0..vec.len() {
                mat[x][y] = vec[j];
                x += 1;
                y += 1;
            }
        }
        for i in 1..n {
            let mut vec: Vec<i32> = vec![];
            let mut x = 0;
            let mut y = i;
            while x < m && y < n {
                vec.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            vec.sort();
            x = 0;
            y = i;
            for j in 0..vec.len() {
                mat[x][y] = vec[j];
                x += 1;
                y += 1;
            }
        }
        mat
    }
}
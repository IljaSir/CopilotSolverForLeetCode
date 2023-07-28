impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = mat;
        let m = mat.len();
        let n = mat[0].len();
        let mut diagonals = vec![];
        for i in 0..m {
            let mut diagonal = vec![];
            let mut x = i;
            let mut y = 0;
            while x < m && y < n {
                diagonal.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            diagonals.push(diagonal);
        }
        for i in 1..n {
            let mut diagonal = vec![];
            let mut x = 0;
            let mut y = i;
            while x < m && y < n {
                diagonal.push(mat[x][y]);
                x += 1;
                y += 1;
            }
            diagonals.push(diagonal);
        }
        for i in 0..diagonals.len() {
            let mut diagonal = diagonals[i];
            diagonal.sort();
            diagonals[i] = diagonal;
        }
        for i in 0..m {
            let mut x = i;
            let mut y = 0;
            let mut j = 0;
            while x < m && y < n {
                mat[x][y] = diagonals[i][j];
                x += 1;
                y += 1;
                j += 1;
            }
        }
        for i in 1..n {
            let mut x = 0;
            let mut y = i;
            let mut j = 0;
            while x < m && y < n {
                mat[x][y] = diagonals[m + j][j];
                x += 1;
                y += 1;
                j += 1;
            }
        }
        mat
    }
}
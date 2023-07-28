impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let m = matrix.len();
        if m == 0 {
            return vec![];
        }
        let n = matrix[0].len();
        let mut r = vec![vec![false; n]; m];
        let mut result = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut di = 0;
        let mut dj = 1;
        for _ in 0..n * m {
            result.push(matrix[i][j]);
            r[i][j] = true;
            if i + di >= m || i + di < 0 || j + dj >= n || j + dj < 0 || r[i + di][j + dj] {
                let tmp = di;
                di = dj;
                dj = -tmp;
            }
            i += di;
            j += dj;
        }
        result
    }
}
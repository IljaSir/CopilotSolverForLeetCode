impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut res = vec![];
        let m = matrix.len();
        let n = matrix[0].len();
        let mut u = 0;
        let mut d = m - 1;
        let mut l = 0;
        let mut r = n - 1;
        let mut i = 0;
        let mut j = 0;
        while u <= d && l <= r {
            for j in l..=r {
                res.push(matrix[i][j]);
            }
            u += 1;
            for i in u..=d {
                res.push(matrix[i][j]);
            }
            r -= 1;
            if u <= d {
                for j in (l..=r).rev() {
                    res.push(matrix[i][j]);
                }
            }
            d -= 1;
            if l <= r {
                for i in (u..=d).rev() {
                    res.push(matrix[i][j]);
                }
            }
            l += 1;
        }
        res
    }
}
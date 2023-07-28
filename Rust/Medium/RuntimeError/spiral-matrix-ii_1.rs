impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let n = n as usize;
        let mut matrix = vec![vec![0; n]; n];
        let mut num = 1;
        let mut left = 0;
        let mut right = n - 1;
        let mut top = 0;
        let mut bottom = n - 1;
        while left <= right && top <= bottom {
            for i in left..=right {
                matrix[top][i] = num;
                num += 1;
            }
            for i in top + 1..=bottom {
                matrix[i][right] = num;
                num += 1;
            }
            if left < right && top < bottom {
                for i in (left..right).rev() {
                    matrix[bottom][i] = num;
                    num += 1;
                }
                for i in (top + 1..bottom).rev() {
                    matrix[i][left] = num;
                    num += 1;
                }
            }
            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;
        }
        matrix
    }
}
impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let mut matrix: Vec<Vec<i32>> = vec![vec![0; n as usize]; n as usize];
        let mut num = 1;
        let mut left = 0;
        let mut right = n - 1;
        let mut top = 0;
        let mut bottom = n - 1;
        while left <= right && top <= bottom {
            for i in left..=right {
                matrix[top as usize][i as usize] = num;
                num += 1;
            }
            for i in (top + 1)..=bottom {
                matrix[i as usize][right as usize] = num;
                num += 1;
            }
            if left < right && top < bottom {
                for i in (left..right).rev() {
                    matrix[bottom as usize][i as usize] = num;
                    num += 1;
                }
                for i in (top + 1..bottom).rev() {
                    matrix[i as usize][left as usize] = num;
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
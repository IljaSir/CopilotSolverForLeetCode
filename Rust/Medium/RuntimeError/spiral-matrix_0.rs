impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut result = vec![];
        let mut top = 0;
        let mut bottom = matrix.len() - 1;
        let mut left = 0;
        let mut right = matrix[0].len() - 1;
        let mut dir = 0;
        while top <= bottom && left <= right {
            if dir == 0 {
                for i in left..=right {
                    result.push(matrix[top][i]);
                }
                top += 1;
            } else if dir == 1 {
                for i in top..=bottom {
                    result.push(matrix[i][right]);
                }
                right -= 1;
            } else if dir == 2 {
                for i in (left..=right).rev() {
                    result.push(matrix[bottom][i]);
                }
                bottom -= 1;
            } else if dir == 3 {
                for i in (top..=bottom).rev() {
                    result.push(matrix[i][left]);
                }
                left += 1;
            }
            dir = (dir + 1) % 4;
        }
        result
    }
}
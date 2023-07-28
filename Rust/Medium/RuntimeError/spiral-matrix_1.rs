impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut ans = Vec::new();
        let mut left = 0;
        let mut right = n - 1;
        let mut top = 0;
        let mut bottom = m - 1;
        while left <= right && top <= bottom {
            for i in left..=right {
                ans.push(matrix[top][i]);
            }
            for i in top + 1..=bottom {
                ans.push(matrix[i][right]);
            }
            if left < right && top < bottom {
                for i in (left..right).rev() {
                    ans.push(matrix[bottom][i]);
                }
                for i in (top + 1..bottom).rev() {
                    ans.push(matrix[i][left]);
                }
            }
            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;
        }
        ans
    }
}
impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        
        let m = matrix.len();
        if m == 0 {
            return 0;
        }
        let n = matrix[0].len();
        if n == 0 {
            return 0;
        }
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == '1' {
                    dp[i][j] = if i == 0 { 1 } else { dp[i - 1][j] + 1 };
                }
            }
        }
        let mut max_area = 0;
        for i in 0..m {
            let mut stack = vec![];
            for j in 0..n {
                while !stack.is_empty() && dp[i][stack[stack.len() - 1]] > dp[i][j] {
                    let idx = stack.pop().unwrap();
                    let width = if stack.is_empty() { j } else { j - stack[stack.len() - 1] - 1 };
                    max_area = max_area.max(dp[i][idx] * width);
                }
                stack.push(j);
            }
            while !stack.is_empty() {
                let idx = stack.pop().unwrap();
                let width = if stack.is_empty() { n } else { n - stack[stack.len() - 1] - 1 };
                max_area = max_area.max(dp[i][idx] * width);
            }
        }
        max_area
    }
}
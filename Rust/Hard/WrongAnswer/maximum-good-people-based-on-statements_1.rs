impl Solution {
    pub fn maximum_good(statements: Vec<Vec<i32>>) -> i32 {
        
        let n = statements.len();
        let mut ans = 0;
        for i in 0..n {
            let mut is_good = true;
            let mut visited = vec![false; n];
            for j in 0..n {
                if statements[i][j] == 0 {
                    visited[j] = true;
                }
            }
            for j in 0..n {
                if visited[j] {
                    for k in 0..n {
                        if statements[j][k] == 0 {
                            visited[k] = true;
                        }
                    }
                }
            }
            for j in 0..n {
                if statements[i][j] == 1 && visited[j] {
                    is_good = false;
                    break;
                }
            }
            if is_good {
                ans += 1;
            }
        }
        ans
    }
}
impl Solution {
    pub fn minimize_result(expression: String) -> String {
        
        let mut dp = vec![vec![vec![vec![]; 2]; expression.len()]; expression.len()];
        let mut i = 0;
        while i < expression.len() {
            let mut j = i;
            while j < expression.len() {
                if i == j {
                    dp[i][j][0].push(expression[i..=j].parse::<i32>().unwrap());
                    dp[i][j][1].push(expression[i..=j].parse::<i32>().unwrap());
                } else {
                    let mut k = i;
                    while k < j {
                        for x in &dp[i][k][0] {
                            for y in &dp[k+1][j][1] {
                                dp[i][j][0].push(*x + *y);
                                dp[i][j][1].push(*x + *y);
                            }
                        }
                        for x in &dp[i][k][1] {
                            for y in &dp[k+1][j][0] {
                                dp[i][j][0].push(*x + *y);
                                dp[i][j][1].push(*x * *y);
                            }
                        }
                        k += 1;
                    }
                }
                j += 1;
            }
            i += 1;
        }
        let mut ans = String::new();
        let mut i = 0;
        while i < expression.len() {
            let mut j = i;
            while j < expression.len() {
                if i == j {
                    ans.push(expression[i]);
                } else if dp[i][j][0].iter().min() == dp[i][j][1].iter().min() {
                    ans.push('(');
                    ans.push(expression[i]);
                    ans.push('+');
                    ans.push(expression[j]);
                    ans.push(')');
                } else {
                    ans.push(expression[i]);
                    ans.push('+');
                    ans.push(expression[j]);
                }
                j += 1;
            }
            i += 1;
        }
        ans
    }
}
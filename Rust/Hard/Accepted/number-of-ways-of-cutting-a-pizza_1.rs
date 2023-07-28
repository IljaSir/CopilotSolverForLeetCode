impl Solution {
    pub fn ways(pizza: Vec<String>, k: i32) -> i32 {
        
        let mut dp = vec![vec![vec![0; 11]; 50]; 50];
        let mut s = vec![vec![0; 51]; 51];
        let m = pizza.len();
        let n = pizza[0].len();
        for i in 0..m {
            for j in (0..n).rev() {
                s[i][j] = s[i][j+1] + (pizza[i].chars().nth(j).unwrap() == 'A') as i32;
            }
        }
        for j in 0..n {
            for i in (0..m).rev() {
                s[i][j] += s[i+1][j];
            }
        }
        fn dfs(pizza: &Vec<String>, k: i32, s: &Vec<Vec<i32>>, dp: &mut Vec<Vec<Vec<i32>>>, i: usize, j: usize) -> i32 {
            let m = pizza.len();
            let n = pizza[0].len();
            if s[i][j] == 0 { return 0; }
            if k == 1 { return 1; }
            if dp[i][j][k as usize] > 0 { return dp[i][j][k as usize]; }
            let mut ans = 0;
            for a in i+1..m {
                if s[i][j] - s[a][j] > 0 {
                    ans += dfs(pizza, k-1, s, dp, a, j);
                    ans %= 1000_000_007;
                }
            }
            for b in j+1..n {
                if s[i][j] - s[i][b] > 0 {
                    ans += dfs(pizza, k-1, s, dp, i, b);
                    ans %= 1000_000_007;
                }
            }
            dp[i][j][k as usize] = ans;
            ans
        }
        dfs(&pizza, k, &s, &mut dp, 0, 0)
    }
}
impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut dp = vec![vec![0; destination[1] as usize + 1]; destination[0] as usize + 1];
        for i in 0..=destination[0] as usize {
            for j in 0..=destination[1] as usize {
                if i == 0 && j == 0 {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp.get(i - 1).map_or(0, |v| v[j]) + dp[i].get(j - 1).map_or(0, |v| *v);
                }
            }
        }
        let mut ans = String::new();
        let mut x = destination[0] as usize;
        let mut y = destination[1] as usize;
        let mut k = k - 1;
        while x > 0 || y > 0 {
            if x == 0 {
                y -= 1;
                ans.push('V');
            } else if y == 0 {
                x -= 1;
                ans.push('H');
            } else {
                if dp[x][y - 1] > k as usize {
                    y -= 1;
                    ans.push('V');
                } else {
                    k -= dp[x][y - 1] as i32;
                    x -= 1;
                    ans.push('H');
                }
            }
        }
        ans
    }
}
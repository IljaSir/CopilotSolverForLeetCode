impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let n = colors.len();
        let mut dp = vec![vec![0; 26]; n];
        let mut last = vec![vec![0; 26]; n];
        let mut last_color = vec![vec![0; 26]; n];
        let mut colors = colors.chars().collect::<Vec<_>>();
        for i in 0..26 {
            dp[0][i] = needed_time[0];
            last[0][i] = 0;
            last_color[0][i] = 0;
        }
        for i in 1..n {
            for j in 0..26 {
                dp[i][j] = dp[i - 1][j] + needed_time[i];
                last[i][j] = i;
                last_color[i][j] = j;
            }
            for j in 0..26 {
                if colors[i] as usize - 'a' as usize == j {
                    continue;
                }
                let mut min = std::i32::MAX;
                let mut min_index = 0;
                for k in 0..26 {
                    if k == j {
                        continue;
                    }
                    if dp[i - 1][k] < min {
                        min = dp[i - 1][k];
                        min_index = k;
                    }
                }
                dp[i][j] = min + needed_time[i];
                last[i][j] = last[i - 1][min_index];
                last_color[i][j] = min_index;
            }
        }
        let mut min = std::i32::MAX;
        let mut min_index = 0;
        for i in 0..26 {
            if dp[n - 1][i] < min {
                min = dp[n - 1][i];
                min_index = i;
            }
        }
        let mut res = vec![0; n];
        let mut res_index = n - 1;
        let mut i = n - 1;
        while i >= 0 {
            res[res_index] = last[i][min_index];
            res_index = last[i][min_index] - 1;
            let t = last_color[i][min_index];
            min_index = t;
            i = last[i][min_index] - 1;
        }
        min
    }
}
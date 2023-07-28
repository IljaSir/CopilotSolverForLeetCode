impl Solution {
    pub fn minimize_the_difference(mat: Vec<Vec<i32>>, target: i32) -> i32 {
        
        let mut dp = vec![0; 71 * 70 + 1];
        dp[0] = 1;
        let mut sum = 0;
        for row in mat {
            let mut next = vec![0; 71 * 70 + 1];
            for (i, &v) in row.iter().enumerate() {
                for j in 0..=sum {
                    if dp[j] == 1 {
                        next[j + v as usize] = 1;
                    }
                }
                sum += v;
            }
            dp = next;
        }
        let mut ans = 800;
        for i in 0..=sum {
            if dp[i] == 1 {
                ans = ans.min((i as i32 - target).abs());
            }
        }
        ans
    }
}
impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = points[0].clone();
        let mut dp2 = vec![0; dp.len()];
        for row in points.iter().skip(1) {
            let mut prev = 0;
            for i in 0..dp.len() {
                dp2[i] = dp[i] + prev;
                if i > 0 {
                    let v = dp[i - 1] - (i - 1) as i32;
                    if v > prev {
                        prev = v;
                    }
                }
            }
            prev = 0;
            for i in (0..dp.len()).rev() {
                let v = dp[i] + (i as i32) + prev;
                if v > dp2[i] {
                    dp2[i] = v;
                }
                if i < dp.len() - 1 {
                    let v = dp[i + 1] + (i + 1) as i32;
                    if v > prev {
                        prev = v;
                    }
                }
            }
            dp = dp2.clone();
        }
        *dp.iter().max().unwrap() as i64
    }
}
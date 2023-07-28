impl Solution {
    pub fn num_ways(words: Vec<String>, target: String) -> i32 {
        
        let mut words: Vec<Vec<i32>> = words.iter().map(|s| s.chars().map(|c| c as i32 - 'a' as i32).collect()).collect();
        let target: Vec<i32> = target.chars().map(|c| c as i32 - 'a' as i32).collect();
        let mut dp: Vec<Vec<i32>> = vec![vec![0; target.len()]; words.len()];
        for i in 0..words.len() {
            for j in 0..target.len() {
                if words[i][0] == target[j] {
                    dp[i][j] += 1;
                }
            }
        }
        for i in 1..words[0].len() {
            let mut count: Vec<i32> = vec![0; 26];
            for j in 0..words.len() {
                count[words[j][i] as usize] += 1;
            }
            for j in 0..words.len() {
                for k in 0..target.len() {
                    if words[j][i] == target[k] {
                        dp[j][k] += dp[j][k-1];
                    }
                    dp[j][k] %= 1_000_000_007;
                }
            }
        }
        dp.iter().map(|v| v[target.len()-1]).sum::<i32>() % 1_000_000_007
    }
}
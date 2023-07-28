impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k as i64;
        let mut sum = 0;
        for i in 0..chalk.len() {
            sum += chalk[i] as i64;
        }
        k %= sum;
        for i in 0..chalk.len() {
            if k < chalk[i] as i64 {
                return i as i32;
            }
            k -= chalk[i] as i64;
        }
        0
    }
}
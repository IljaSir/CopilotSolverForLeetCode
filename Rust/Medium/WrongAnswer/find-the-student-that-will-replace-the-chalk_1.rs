impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let sum: i32 = chalk.iter().sum();
        k %= sum;
        for i in 0..chalk.len() {
            k -= chalk[i];
            if k < 0 {
                return i as i32;
            }
        }
        0
    }
}
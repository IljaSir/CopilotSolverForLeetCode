impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let sum: i64 = chalk.iter().map(|x| *x as i64).sum();
        let mut k = k as i64;
        k %= sum;
        for (i, x) in chalk.iter().enumerate() {
            k -= *x as i64;
            if k < 0 {
                return i as i32;
            }
        }
        0
    }
}
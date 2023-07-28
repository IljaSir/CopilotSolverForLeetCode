impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let n = chalk.len() as i32;
        let mut sum = 0;
        for &i in chalk.iter() {
            sum += i;
        }
        let mut k = k % sum;
        for i in 0..n {
            if k < chalk[i as usize] {
                return i;
            }
            k -= chalk[i as usize];
        }
        0
    }
}
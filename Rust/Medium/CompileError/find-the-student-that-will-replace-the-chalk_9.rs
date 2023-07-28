impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k as usize;
        let mut i = 0;
        let mut n = chalk.len();
        let mut sum = 0;
        for i in 0..n {
            sum += chalk[i];
        }
        k %= sum;
        while k >= chalk[i] as usize {
            k -= chalk[i] as usize;
            i += 1;
        }
        i as i32
    }
}
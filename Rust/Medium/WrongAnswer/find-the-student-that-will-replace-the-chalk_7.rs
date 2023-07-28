impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 0;
        let mut sum = 0;
        for &c in chalk.iter() {
            sum += c;
        }
        k %= sum;
        while k >= 0 {
            k -= chalk[i];
            i += 1;
        }
        (i - 1) as i32
    }
}
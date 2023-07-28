impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut sum = 0;
        for &c in chalk.iter() {
            sum += c;
        }
        k %= sum;
        for (i, &c) in chalk.iter().enumerate() {
            if k < c {
                return i as i32;
            }
            k -= c;
        }
        0
    }
}
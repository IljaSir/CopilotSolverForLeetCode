impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 0;
        let mut j = chalk.len();
        let mut sum = 0;
        while i < j {
            let m = (i + j) / 2;
            sum += chalk[m];
            if sum > k {
                j = m;
            } else {
                i = m + 1;
            }
        }
        if i == chalk.len() {
            0
        } else {
            i as i32
        }
    }
}
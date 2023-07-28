impl Solution {
    pub fn chalk_replacer(chalk: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 0;
        while k >= chalk[i] {
            k -= chalk[i];
            i += 1;
            if i == chalk.len() {
                i = 0;
            }
        }
        i as i32
    }
}
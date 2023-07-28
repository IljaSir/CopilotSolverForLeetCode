impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut flag = 0;
        let mut count = 0;
        for c in target.chars() {
            if c == '1' && flag == 0 {
                count += 1;
                flag = 1;
            } else if c == '0' && flag == 1 {
                count += 1;
                flag = 0;
            }
        }
        count
    }
}
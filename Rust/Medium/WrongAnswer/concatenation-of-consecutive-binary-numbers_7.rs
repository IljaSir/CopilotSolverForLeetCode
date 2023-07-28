impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut power = 0;
        for i in (1..=n).rev() {
            if i & (i + 1) == 0 {
                power += 1;
            }
            sum = (sum + i * 2i32.pow(power as u32)) % (10i32.pow(9) + 7);
        }
        sum
    }
}
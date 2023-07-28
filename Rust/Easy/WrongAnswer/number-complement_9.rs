impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut i = 0;
        let mut x = 0;
        while i <= 31 {
            x = x | (1 << i);
            i += 1;
        }
        x - num
    }
}
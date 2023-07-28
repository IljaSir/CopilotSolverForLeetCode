impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut n = num;
        let mut mask = 0;
        while n > 0 {
            mask = mask * 2 + 1;
            n = n >> 1;
        }
        mask ^ num
    }
}
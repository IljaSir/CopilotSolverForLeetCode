impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut mask = !0;
        while mask & num != 0 {
            mask <<= 1;
        }
        !mask & !num
    }
}
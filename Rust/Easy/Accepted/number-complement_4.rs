impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        
        let mut num = num;
        let mut res = 0;
        let mut i = 0;
        while num > 0 {
            res += ((num & 1) ^ 1) << i;
            num >>= 1;
            i += 1;
        }
        res
    }
}
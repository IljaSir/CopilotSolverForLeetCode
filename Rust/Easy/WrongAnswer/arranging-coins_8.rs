impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let mut i = 1;
        let mut count = 0;
        while n >= i {
            count += 1;
            i += 1;
        }
        count
    }
}
impl Solution {
    pub fn even_odd_bit(n: i32) -> Vec<i32> {
        
        let mut ret: Vec<i32> = vec![0; 2];
        let mut n = n;
        let mut i = 0;
        while n != 0 {
            if n & 1 == 1 {
                ret[i as usize] += 1;
            }
            n >>= 1;
            i += 1;
        }
        ret
    }
}
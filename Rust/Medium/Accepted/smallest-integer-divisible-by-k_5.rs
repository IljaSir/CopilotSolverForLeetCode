impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        if k % 2 == 0 || k % 5 == 0 {
            return -1;
        }
        let mut num = 0;
        for i in 1..k+1 {
            num = (num * 10 + 1) % k;
            if num == 0 {
                return i;
            }
        }
        -1
    }
}
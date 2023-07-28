impl Solution {
    pub fn get_no_zero_integers(n: i32) -> Vec<i32> {
        
        let mut res = vec![0, 0];
        let mut a = n;
        let mut b = 0;
        let mut i = 1;
        while a > 0 {
            b = a % 10;
            a = a / 10;
            if b == 0 {
                res[0] = i;
            } else if b == 1 {
                res[0] = i * 10;
            } else {
                res[0] = i * b;
                res[1] = i * (10 - b);
            }
            i = i * 10;
        }
        res
    }
}
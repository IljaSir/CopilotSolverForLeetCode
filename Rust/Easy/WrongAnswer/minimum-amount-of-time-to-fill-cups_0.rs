impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut a = amount[0];
        let mut b = amount[1];
        let mut c = amount[2];
        let mut ans = 0;
        while a > 0 || b > 0 || c > 0 {
            if a > 0 && b > 0 {
                a -= 1;
                b -= 1;
                ans += 1;
            }
            if b > 0 && c > 0 {
                b -= 1;
                c -= 1;
                ans += 1;
            }
            if a > 0 && c > 0 {
                a -= 1;
                c -= 1;
                ans += 1;
            }
            if a > 0 {
                a -= 1;
                ans += 1;
            }
            if b > 0 {
                b -= 1;
                ans += 1;
            }
            if c > 0 {
                c -= 1;
                ans += 1;
            }
        }
        ans
    }
}
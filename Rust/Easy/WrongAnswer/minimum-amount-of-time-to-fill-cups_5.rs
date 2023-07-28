impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut a = amount[0];
        let mut b = amount[1];
        let mut c = amount[2];
        let mut ans = 0;
        if a > 0 {
            ans += 1;
            a -= 1;
        }
        if b > 0 {
            ans += 1;
            b -= 1;
        }
        if c > 0 {
            ans += 1;
            c -= 1;
        }
        let mut max = a;
        if b > max {
            max = b;
        }
        if c > max {
            max = c;
        }
        ans += max;
        ans
    }
}
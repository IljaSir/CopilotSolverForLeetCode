impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut res = String::new();
        let mut last = 0;
        let mut a = a;
        let mut b = b;
        let mut c = c;
        while a > 0 || b > 0 || c > 0 {
            if a >= b && a >= c && last != 1 {
                res.push('a');
                last = 1;
                a -= 1;
            } else if b >= a && b >= c && last != 2 {
                res.push('b');
                last = 2;
                b -= 1;
            } else if c >= a && c >= b && last != 3 {
                res.push('c');
                last = 3;
                c -= 1;
            } else if a > 0 && last != 1 {
                res.push('a');
                last = 1;
                a -= 1;
            } else if b > 0 && last != 2 {
                res.push('b');
                last = 2;
                b -= 1;
            } else if c > 0 && last != 3 {
                res.push('c');
                last = 3;
                c -= 1;
            } else {
                break;
            }
            if res.len() > 1 && res.chars().nth(res.len()-2).unwrap() == res.chars().nth(res.len()-1).unwrap() {
                res.pop();
                last = 0;
            }
        }
        res
    }
}
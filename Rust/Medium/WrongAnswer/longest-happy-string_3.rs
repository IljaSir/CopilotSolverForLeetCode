impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut res = String::new();
        let mut last = ' ';
        while a > 0 || b > 0 || c > 0 {
            if a > b && a > c && (last != 'a' || (last == 'a' && b == 0 && c == 0)) {
                res.push('a');
                a -= 1;
                last = 'a';
            } else if b > c && (last != 'b' || (last == 'b' && a == 0 && c == 0)) {
                res.push('b');
                b -= 1;
                last = 'b';
            } else if c > 0 && (last != 'c' || (last == 'c' && a == 0 && b == 0)) {
                res.push('c');
                c -= 1;
                last = 'c';
            } else if a > 0 && (last != 'a' || (last == 'a' && b == 0 && c == 0)) {
                res.push('a');
                a -= 1;
                last = 'a';
            } else if b > 0 && (last != 'b' || (last == 'b' && a == 0 && c == 0)) {
                res.push('b');
                b -= 1;
                last = 'b';
            } else if c > 0 && (last != 'c' || (last == 'c' && a == 0 && b == 0)) {
                res.push('c');
                c -= 1;
                last = 'c';
            } else {
                break;
            }
        }
        res
    }
}
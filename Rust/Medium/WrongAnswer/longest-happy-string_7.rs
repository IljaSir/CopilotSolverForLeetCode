impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut ans = String::new();
        let mut last = ' ';
        let mut last_count = 0;
        let mut a = a;
        let mut b = b;
        let mut c = c;
        while a > 0 || b > 0 || c > 0 {
            if a >= b && a >= c && (last != 'a' || last_count < 2) {
                ans.push('a');
                last = 'a';
                last_count += 1;
                a -= 1;
            } else if b >= a && b >= c && (last != 'b' || last_count < 2) {
                ans.push('b');
                last = 'b';
                last_count += 1;
                b -= 1;
            } else if c >= a && c >= b && (last != 'c' || last_count < 2) {
                ans.push('c');
                last = 'c';
                last_count += 1;
                c -= 1;
            } else if a > 0 && last != 'a' {
                ans.push('a');
                last = 'a';
                last_count = 1;
                a -= 1;
            } else if b > 0 && last != 'b' {
                ans.push('b');
                last = 'b';
                last_count = 1;
                b -= 1;
            } else if c > 0 && last != 'c' {
                ans.push('c');
                last = 'c';
                last_count = 1;
                c -= 1;
            } else {
                break;
            }
        }
        ans
    }
}
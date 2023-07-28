impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut res = String::new();
        while a > 0 || b > 0 || c > 0 {
            let mut used_a = false;
            let mut used_b = false;
            let mut used_c = false;
            if (a >= b && a >= c && a > 0) || (a > 0 && (res.ends_with("aa") || res.ends_with("bb") || res.ends_with("cc"))) {
                res.push('a');
                a -= 1;
                used_a = true;
            }
            if (b >= a && b >= c && b > 0) || (b > 0 && (res.ends_with("aa") || res.ends_with("bb") || res.ends_with("cc"))) {
                res.push('b');
                b -= 1;
                used_b = true;
            }
            if (c >= a && c >= b && c > 0) || (c > 0 && (res.ends_with("aa") || res.ends_with("bb") || res.ends_with("cc"))) {
                res.push('c');
                c -= 1;
                used_c = true;
            }
            if used_a && used_b && used_c {
                break;
            }
        }
        res
    }
}
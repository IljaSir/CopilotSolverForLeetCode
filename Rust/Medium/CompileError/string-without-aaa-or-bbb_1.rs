impl Solution {
    pub fn str_without3a3b(a: i32, b: i32) -> String {
        
        let mut a = a;
        let mut b = b;
        let mut res = String::new();
        while a > 0 || b > 0 {
            let mut write_a = false;
            let l = res.len();
            if l >= 2 && res[l - 1..] == res[l - 2..l] {
                if res[l - 1..] == "b" {
                    write_a = true;
                }
            } else {
                if a >= b {
                    write_a = true;
                }
            }
            if write_a {
                res.push('a');
                a -= 1;
            } else {
                res.push('b');
                b -= 1;
            }
        }
        res
    }
}
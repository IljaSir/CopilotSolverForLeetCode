impl Solution {
    pub fn str_without3a3b(a: i32, b: i32) -> String {
        
        let mut a = a;
        let mut b = b;
        let mut s = String::new();
        let mut last = ' ';
        while a > 0 || b > 0 {
            let mut use_a = false;
            if a > b {
                use_a = true;
            } else if a < b {
                use_a = false;
            } else {
                use_a = last != 'a';
            }
            if use_a {
                if last == 'a' {
                    s.push('b');
                    b -= 1;
                } else {
                    s.push('a');
                    a -= 1;
                }
            } else {
                if last == 'b' {
                    s.push('a');
                    a -= 1;
                } else {
                    s.push('b');
                    b -= 1;
                }
            }
            last = s.chars().last().unwrap();
        }
        s
    }
}
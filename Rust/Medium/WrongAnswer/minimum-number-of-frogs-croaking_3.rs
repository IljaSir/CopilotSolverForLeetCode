impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut frogs = 0;
        let mut c = 0;
        let mut r = 0;
        let mut o = 0;
        let mut a = 0;
        let mut k = 0;
        for ch in croak_of_frogs.chars() {
            match ch {
                'c' => {
                    c += 1;
                    frogs = frogs.max(c);
                },
                'r' => {
                    r += 1;
                    if r > c {
                        return -1;
                    }
                },
                'o' => {
                    o += 1;
                    if o > r {
                        return -1;
                    }
                },
                'a' => {
                    a += 1;
                    if a > o {
                        return -1;
                    }
                },
                'k' => {
                    k += 1;
                    if k > a {
                        return -1;
                    }
                },
                _ => unreachable!()
            }
        }
        if c == r && r == o && o == a && a == k {
            frogs
        } else {
            -1
        }
    }
}
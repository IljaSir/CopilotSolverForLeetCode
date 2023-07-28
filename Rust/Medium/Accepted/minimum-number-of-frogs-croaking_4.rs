impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut croak_of_frogs = croak_of_frogs.into_bytes();
        let mut c = 0;
        let mut r = 0;
        let mut o = 0;
        let mut a = 0;
        let mut k = 0;
        let mut max = 0;
        let mut frogs = 0;
        for i in 0..croak_of_frogs.len() {
            match croak_of_frogs[i] {
                b'c' => {
                    c += 1;
                    frogs += 1;
                    max = max.max(frogs);
                },
                b'r' => {
                    r += 1;
                    if r > c {
                        return -1;
                    }
                },
                b'o' => {
                    o += 1;
                    if o > r {
                        return -1;
                    }
                },
                b'a' => {
                    a += 1;
                    if a > o {
                        return -1;
                    }
                },
                b'k' => {
                    k += 1;
                    if k > a {
                        return -1;
                    }
                    frogs -= 1;
                },
                _ => return -1,
            }
        }
        if c == r && r == o && o == a && a == k {
            max
        } else {
            -1
        }
    }
}
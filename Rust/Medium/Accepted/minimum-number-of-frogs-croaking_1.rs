impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut c = 0;
        let mut r = 0;
        let mut o = 0;
        let mut a = 0;
        let mut k = 0;
        let mut frogs = 0;
        let mut max_frogs = 0;
        for ch in croak_of_frogs.chars() {
            match ch {
                'c' => {
                    c += 1;
                    frogs += 1;
                    if frogs > max_frogs {
                        max_frogs = frogs;
                    }
                }
                'r' => {
                    if c <= r {
                        return -1;
                    }
                    r += 1;
                }
                'o' => {
                    if r <= o {
                        return -1;
                    }
                    o += 1;
                }
                'a' => {
                    if o <= a {
                        return -1;
                    }
                    a += 1;
                }
                'k' => {
                    if a <= k {
                        return -1;
                    }
                    k += 1;
                    frogs -= 1;
                }
                _ => unreachable!(),
            }
        }
        if c == r && r == o && o == a && a == k {
            max_frogs
        } else {
            -1
        }
    }
}
impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut c = 0;
        let mut r = 0;
        let mut o = 0;
        let mut a = 0;
        let mut k = 0;
        let mut res = 0;
        for ch in croak_of_frogs.chars() {
            match ch {
                'c' => c += 1,
                'r' => r += 1,
                'o' => o += 1,
                'a' => a += 1,
                'k' => k += 1,
                _ => return -1,
            }
            if c < r || c < o || c < a || c < k {
                return -1;
            }
            res = res.max(c - k);
        }
        if c != r || c != o || c != a || c != k {
            return -1;
        }
        res
    }
}
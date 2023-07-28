impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut has_0 = false;
        let mut has_1 = false;
        let mut dp0 = 1;
        let mut dp1 = 0;
        let mut mod_val = 1_000_000_007;
        for c in binary.chars() {
            if c == '0' {
                has_0 = true;
                dp0 = (dp0 + dp1) % mod_val;
            } else {
                has_1 = true;
                dp1 = (dp0 + dp1) % mod_val;
            }
        }
        let mut res = dp0 + dp1;
        if has_0 {
            res -= 1;
        }
        (res % mod_val) as i32
    }
}
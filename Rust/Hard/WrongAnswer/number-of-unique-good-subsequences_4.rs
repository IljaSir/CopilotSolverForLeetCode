impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        const MOD: i64 = 1_000_000_000 + 7;
        let mut has_zero = false;
        let mut count = 1;
        let mut prev = 0;
        for c in binary.chars() {
            if c == '0' {
                has_zero = true;
            } else if prev == 0 {
                count += 1;
            } else if prev == 1 {
                count = 2 * count - 1;
            }
            prev = if c == '0' { 0 } else { 1 };
            count %= MOD;
        }
        if has_zero { count = (count + MOD - 1) % MOD; }
        count as i32
    }
}
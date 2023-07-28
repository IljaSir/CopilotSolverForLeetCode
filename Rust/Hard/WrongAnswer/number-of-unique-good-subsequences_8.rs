impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut count = 0;
        let mut zero = 0;
        let mut one = 0;
        let mut pre = '0';
        for c in binary.chars() {
            if c == '0' {
                if pre == '0' {
                    zero = 1;
                } else {
                    zero = one + 1;
                }
            } else {
                one = zero + one + 1;
            }
            pre = c;
        }
        if pre == '0' {
            one
        } else {
            (one + zero) % 1_000_000_007
        }
    }
}
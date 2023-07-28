impl Solution {
    pub fn is_one_bit_character(bits: Vec<i32>) -> bool {
        
        let mut i = 0;
        while i < bits.len() {
            if i == bits.len() - 1 {
                return true;
            }
            if bits[i] == 0 {
                i += 1;
            } else {
                i += 2;
            }
        }
        false
    }
}
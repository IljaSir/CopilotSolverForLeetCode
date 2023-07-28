impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut dict = [0; 26];
        for c in s.chars() {
            dict[c as usize - 'a' as usize] += 1;
        }
        let mut digits = [0; 10];
        digits[0] = dict['z' as usize - 'a' as usize];
        digits[2] = dict['w' as usize - 'a' as usize];
        digits[4] = dict['u' as usize - 'a' as usize];
        digits[6] = dict['x' as usize - 'a' as usize];
        digits[8] = dict['g' as usize - 'a' as usize];
        digits[3] = dict['h' as usize - 'a' as usize] - digits[8];
        digits[5] = dict['f' as usize - 'a' as usize] - digits[4];
        digits[7] = dict['s' as usize - 'a' as usize] - digits[6];
        digits[1] = dict['o' as usize - 'a' as usize] - digits[0] - digits[2] - digits[4];
        digits[9] = dict['i' as usize - 'a' as usize] - digits[5] - digits[6] - digits[8];
        let mut result = String::new();
        for i in 0..10 {
            for _ in 0..digits[i] {
                result.push((i + '0' as u8) as char);
            }
        }
        result
    }
}
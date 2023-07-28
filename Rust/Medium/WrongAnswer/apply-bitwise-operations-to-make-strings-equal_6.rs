impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut count = [0; 2];
        for (a, b) in s.as_bytes().iter().zip(target.as_bytes().iter()) {
            count[*a as usize - 48] += 1;
            count[*b as usize - 48] -= 1;
        }
        count[0] == 0 && count[1] == 0
    }
}
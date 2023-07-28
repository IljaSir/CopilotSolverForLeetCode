impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut c = [0; 3];
        let mut r = 0;
        let mut res = 0;
        for (l, b) in s.bytes().enumerate() {
            c[(b - b'a') as usize] += 1;
            while c[0] > 0 && c[1] > 0 && c[2] > 0 {
                c[(s.as_bytes()[r] - b'a') as usize] -= 1;
                r += 1;
            }
            res += r;
        }
        res as i32
    }
}
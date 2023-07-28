impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut counts = vec![0; 10];
        let mut chars = vec![0; 26];
        for c in s.chars() {
            chars[(c as u8 - b'a') as usize] += 1;
        }
        counts[0] = chars[(b'z' - b'a') as usize];
        counts[2] = chars[(b'w' - b'a') as usize];
        counts[4] = chars[(b'u' - b'a') as usize];
        counts[6] = chars[(b'x' - b'a') as usize];
        counts[8] = chars[(b'g' - b'a') as usize];
        counts[1] = chars[(b'o' - b'a') as usize] - counts[0] - counts[2] - counts[4];
        counts[3] = chars[(b't' - b'a') as usize] - counts[2] - counts[8];
        counts[5] = chars[(b'f' - b'a') as usize] - counts[4];
        counts[7] = chars[(b's' - b'a') as usize] - counts[6];
        counts[9] = chars[(b'i' - b'a') as usize] - counts[5] - counts[6] - counts[8];
        let mut result = String::new();
        for i in 0..10 {
            for _ in 0..counts[i] {
                result.push((i as u8 + b'0') as char);
            }
        }
        result
    }
}
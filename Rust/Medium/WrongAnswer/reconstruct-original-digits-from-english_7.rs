impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let s = s.as_bytes();
        let mut counter = [0; 26];
        for &c in s {
            counter[(c - b'a') as usize] += 1;
        }
        let mut ans = String::new();
        let mut count = [0; 10];
        count[0] = counter[25];
        count[2] = counter[22];
        count[4] = counter[5];
        count[6] = counter[23];
        count[8] = counter[6];
        count[1] = counter[14] - count[0] - count[2] - count[4];
        count[3] = counter[7] - count[8];
        count[5] = counter[21] - count[4];
        count[7] = counter[18] - count[6];
        count[9] = (counter[13] - count[8] - count[6]) / 2;
        for (i, &c) in count.iter().enumerate() {
            for _ in 0..c {
                ans.push((i as u8 + b'0') as char);
            }
        }
        ans
    }
}
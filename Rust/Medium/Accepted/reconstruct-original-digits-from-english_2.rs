impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut res = String::new();
        let mut count = vec![0; 10];
        for c in s.chars() {
            match c {
                'z' => count[0] += 1,
                'w' => count[2] += 1,
                'u' => count[4] += 1,
                'x' => count[6] += 1,
                'g' => count[8] += 1,
                'o' => count[1] += 1,
                'h' => count[3] += 1,
                'f' => count[5] += 1,
                's' => count[7] += 1,
                'i' => count[9] += 1,
                _ => (),
            }
        }
        count[1] -= count[0] + count[2] + count[4];
        count[3] -= count[8];
        count[5] -= count[4];
        count[7] -= count[6];
        count[9] -= count[5] + count[6] + count[8];
        for i in 0..10 {
            res += &i.to_string().repeat(count[i] as usize);
        }
        res
    }
}
impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut count0 = 0;
        let mut count1 = 0;
        for c in s.chars() {
            match c {
                '0' => count0 += 1,
                '1' => count1 += 1,
                _ => (),
            }
        }
        for c in s.chars() {
            match c {
                '0' => {
                    count0 -= 1;
                    count += 1;
                },
                '1' => {
                    count1 -= 1;
                },
                _ => (),
            }
            if count + count1 > max {
                max = count + count1;
            }
        }
        max
    }
}
impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum = 0;
        let mut prev = 0;
        for c in s.chars().rev() {
            let cur = match c {
                'I' => 1,
                'V' => 5,
                'X' => 10,
                'L' => 50,
                'C' => 100,
                'D' => 500,
                'M' => 1000,
                _ => panic!("invalid roman number"),
            };
            if cur < prev {
                sum -= cur;
            } else {
                sum += cur;
            }
            prev = cur;
        }
        sum
    }
}
impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut result = 0;
        let mut last = 0;
        for c in s.chars() {
            let num = match c {
                'M' => 1000,
                'D' => 500,
                'C' => 100,
                'L' => 50,
                'X' => 10,
                'V' => 5,
                'I' => 1,
                _ => 0,
            };
            if last < num {
                result += num - 2 * last;
            } else {
                result += num;
            }
            last = num;
        }
        result
    }
}
impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut sum: i32 = 0;
        let mut chars = s.chars();
        let mut last = ' ';
        while let Some(ch) = chars.next() {
            let val = match ch {
                'I' => 1,
                'V' => 5,
                'X' => 10,
                'L' => 50,
                'C' => 100,
                'D' => 500,
                'M' => 1000,
                _ => 0,
            };
            if last == 'I' && (ch == 'V' || ch == 'X') {
                sum -= 2;
            } else if last == 'X' && (ch == 'L' || ch == 'C') {
                sum -= 20;
            } else if last == 'C' && (ch == 'D' || ch == 'M') {
                sum -= 200;
            }
            sum += val;
            last = ch;
        }
        sum
    }
}
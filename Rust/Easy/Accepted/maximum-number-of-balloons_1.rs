impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut count = 0;
        let mut b = 0;
        let mut a = 0;
        let mut l = 0;
        let mut o = 0;
        let mut n = 0;
        for ch in text.chars() {
            match ch {
                'b' => b += 1,
                'a' => a += 1,
                'l' => l += 1,
                'o' => o += 1,
                'n' => n += 1,
                _ => {}
            }
        }
        while b > 0 && a > 0 && l > 1 && o > 1 && n > 0 {
            b -= 1;
            a -= 1;
            l -= 2;
            o -= 2;
            n -= 1;
            count += 1;
        }
        count
    }
}
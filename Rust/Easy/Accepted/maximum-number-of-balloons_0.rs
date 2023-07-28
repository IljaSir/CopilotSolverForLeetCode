impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut b = 0;
        let mut a = 0;
        let mut l = 0;
        let mut o = 0;
        let mut n = 0;
        for c in text.chars() {
            match c {
                'b' => b += 1,
                'a' => a += 1,
                'l' => l += 1,
                'o' => o += 1,
                'n' => n += 1,
                _ => {}
            }
        }
        let l = l / 2;
        let o = o / 2;
        let mut min = b;
        if min > a {
            min = a;
        }
        if min > l {
            min = l;
        }
        if min > o {
            min = o;
        }
        if min > n {
            min = n;
        }
        min
    }
}
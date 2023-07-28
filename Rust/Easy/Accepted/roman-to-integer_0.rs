impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        
        let mut res = 0;
        let mut pre = 0;
        for c in s.chars() {
            let cur = match c {
                'I' => 1,
                'V' => 5,
                'X' => 10,
                'L' => 50,
                'C' => 100,
                'D' => 500,
                'M' => 1000,
                _ => 0,
            };
            res += cur;
            if pre < cur {
                res -= pre * 2;
            }
            pre = cur;
        }
        res
    }
}
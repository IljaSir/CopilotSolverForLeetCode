impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut t = String::new();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i <= j {
            let mut k = 0;
            while i + k <= j && (j - k < i || s.chars().nth(i + k).unwrap() <= s.chars().nth(j - k).unwrap()) {
                k += 1;
            }
            if i + k <= j {
                k = -k;
            }
            if k > 0 {
                for _ in 0..k {
                    t.push(s.chars().nth(i).unwrap());
                    i += 1;
                }
            } else {
                for _ in k..0 {
                    t.push(s.chars().nth(j).unwrap());
                    j -= 1;
                }
            }
        }
        t
    }
}
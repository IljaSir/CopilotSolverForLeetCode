impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut result = String::new();
        let mut n = num;
        let mut i = 0;
        while n > 0 {
            let mut t = n % 1000;
            n /= 1000;
            if t > 0 {
                let mut s = String::new();
                let h = t / 100;
                t %= 100;
                if h > 0 {
                    s += Self::to_english(h);
                    s += " Hundred";
                }
                if t > 0 {
                    if h > 0 {
                        s += " ";
                    }
                    if t < 20 {
                        s += Self::to_english(t);
                    } else {
                        let d = t / 10;
                        t %= 10;
                        s += Self::to_english(d * 10);
                        if t > 0 {
                            s += " ";
                            s += Self::to_english(t);
                        }
                    }
                }
                if i > 0 {
                    s += " ";
                    s += Self::to_english(1000_i32.pow(i));
                }
                if result.len() > 0 {
                    s += " ";
                }
                s += &result;
                result = s;
            }
            i += 1;
        }
        result
    }
}
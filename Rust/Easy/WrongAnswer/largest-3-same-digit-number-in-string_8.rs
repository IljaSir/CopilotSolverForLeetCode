impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut res = String::from("");
        let mut count = 0;
        let mut pre = ' ';
        for c in num.chars() {
            if c == pre {
                count += 1;
            } else {
                if count >= 3 {
                    let mut s = String::from("");
                    for _ in 0..count {
                        s.push(pre);
                    }
                    res = res.max(s);
                }
                count = 1;
            }
            pre = c;
        }
        if count >= 3 {
            let mut s = String::from("");
            for _ in 0..count {
                s.push(pre);
            }
            res = res.max(s);
        }
        res
    }
}
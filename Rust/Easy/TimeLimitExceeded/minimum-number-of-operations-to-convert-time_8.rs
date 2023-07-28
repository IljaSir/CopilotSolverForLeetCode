impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut current = current.split(":").collect::<Vec<_>>();
        let correct = correct.split(":").collect::<Vec<_>>();
        let mut ans = 0;
        let mut c = current[1].parse::<i32>().unwrap();
        let mut h = current[0].parse::<i32>().unwrap();
        let mut c2 = correct[1].parse::<i32>().unwrap();
        let mut h2 = correct[0].parse::<i32>().unwrap();
        while c != c2 || h != h2 {
            if c < c2 {
                if c2 - c >= 60 {
                    h += 1;
                    c += 60;
                    ans += 1;
                } else if c2 - c >= 15 {
                    c += 15;
                    ans += 1;
                } else if c2 - c >= 5 {
                    c += 5;
                    ans += 1;
                } else {
                    c += 1;
                    ans += 1;
                }
            } else {
                if c - c2 >= 60 {
                    h -= 1;
                    c -= 60;
                    ans += 1;
                } else if c - c2 >= 15 {
                    c -= 15;
                    ans += 1;
                } else if c - c2 >= 5 {
                    c -= 5;
                    ans += 1;
                } else {
                    c -= 1;
                    ans += 1;
                }
            }
            if c >= 60 {
                c -= 60;
                h += 1;
            }
            if c < 0 {
                c += 60;
                h -= 1;
            }
            if h >= 24 {
                h -= 24;
            }
            if h < 0 {
                h += 24;
            }
        }
        ans
    }
}
impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        let mut time = time.chars();
        let h1 = time.next().unwrap();
        let h2 = time.next().unwrap();
        let m1 = time.next().unwrap();
        let m2 = time.next().unwrap();
        let h1 = if h1 == '?' {0} else {h1.to_digit(10).unwrap()};
        let h2 = if h2 == '?' {9} else {h2.to_digit(10).unwrap()};
        let m1 = if m1 == '?' {0} else {m1.to_digit(10).unwrap()};
        let m2 = if m2 == '?' {9} else {m2.to_digit(10).unwrap()};
        for h in h1..=h2 {
            for m in m1..=m2 {
                if h == 2 && m > 3 {continue;}
                if h > 2 && h < 10 {continue;}
                if h == 10 && m > 9 {continue;}
                if h == 11 && m > 9 {continue;}
                if h == 12 && m > 9 {continue;}
                count += 1;
            }
        }
        count
    }
}
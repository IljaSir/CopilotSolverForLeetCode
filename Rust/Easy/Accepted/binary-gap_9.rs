impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut ones = vec![];
        let mut n = n;
        while n > 0 {
            ones.push(n % 2);
            n = n / 2;
        }
        let mut max = 0;
        let mut last = -1;
        for (i, &v) in ones.iter().enumerate() {
            if v == 1 {
                if last != -1 {
                    let d = i as i32 - last;
                    if d > max {
                        max = d;
                    }
                }
                last = i as i32;
            }
        }
        max
    }
}
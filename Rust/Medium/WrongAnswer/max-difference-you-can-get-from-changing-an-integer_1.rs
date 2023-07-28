impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut min = num;
        let mut max = num;
        for i in 0..10 {
            for j in 0..10 {
                let mut n = num;
                let mut m = num;
                while n > 0 {
                    if n % 10 == i {
                        m = m * 10 + j;
                    } else {
                        m = m * 10 + n % 10;
                    }
                    n /= 10;
                }
                if m % 10 == 0 {
                    continue;
                }
                while m > 0 {
                    if m % 10 == j {
                        min = min * 10 + i;
                    } else {
                        min = min * 10 + m % 10;
                    }
                    m /= 10;
                }
                while min > 0 {
                    if min % 10 == i {
                        min = min / 10;
                    } else {
                        break;
                    }
                }
                max = max.max(m);
            }
        }
        max - min
    }
}
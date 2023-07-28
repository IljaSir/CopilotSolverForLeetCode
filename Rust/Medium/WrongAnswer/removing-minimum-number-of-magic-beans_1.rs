impl Solution {
    pub fn minimum_removal(beans: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        for i in 0..beans.len() {
            sum += beans[i];
        }
        let mut avg = sum as f64 / beans.len() as f64;
        if avg - avg.floor() > 0.0000001 {
            avg += 0.0000001;
        }
        let avg = avg as i32;
        let mut res = 0;
        for i in 0..beans.len() {
            if beans[i] > avg {
                res += beans[i] - avg;
            }
        }
        res as i64
    }
}
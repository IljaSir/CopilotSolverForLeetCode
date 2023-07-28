impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut min = i32::MAX;
        let mut max = i32::MIN;
        let num = num.to_string();
        for i in 0..10 {
            for j in 0..10 {
                let mut s = num.clone();
                s = s.replace(&i.to_string(), &j.to_string());
                let n = s.parse::<i32>().unwrap();
                if n < min {
                    min = n;
                }
                if n > max {
                    max = n;
                }
            }
        }
        max - min
    }
}
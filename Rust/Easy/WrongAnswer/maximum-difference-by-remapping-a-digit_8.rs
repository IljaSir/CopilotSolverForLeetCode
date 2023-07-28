impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let s = num.to_string();
        let mut min = s.clone();
        let mut max = s.clone();
        for i in 0..10 {
            let j = 9 - i;
            let mut min2 = min.replace(&i.to_string(), &j.to_string());
            let mut max2 = max.replace(&i.to_string(), &j.to_string());
            if min2.starts_with("0") {
                min2 = min2[1..].to_string();
            }
            if max2.starts_with("0") {
                max2 = max2[1..].to_string();
            }
            min = min2;
            max = max2;
        }
        max.parse::<i32>().unwrap() - min.parse::<i32>().unwrap()
    }
}
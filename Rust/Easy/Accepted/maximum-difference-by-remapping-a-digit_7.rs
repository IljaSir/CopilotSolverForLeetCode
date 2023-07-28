impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut num = num.to_string();
        let mut min = num.clone();
        let mut max = num.clone();
        for d in 0..10 {
            let mut temp = num.clone();
            temp = temp.replace(&d.to_string(), "0");
            if temp != num {
                let temp = temp.parse::<i32>().unwrap();
                if temp < min.parse::<i32>().unwrap() {
                    min = temp.to_string();
                }
            }
        }
        for d in 0..10 {
            let mut temp = num.clone();
            temp = temp.replace(&d.to_string(), "9");
            if temp != num {
                let temp = temp.parse::<i32>().unwrap();
                if temp > max.parse::<i32>().unwrap() {
                    max = temp.to_string();
                }
            }
        }
        max.parse::<i32>().unwrap() - min.parse::<i32>().unwrap()
    }
}
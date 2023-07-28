impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let num = num.to_string();
        let mut max = num.clone();
        let mut min = num.clone();
        for i in 0..10 {
            let mut tmp = num.clone();
            tmp = tmp.replace(i.to_string().as_str(), "0");
            if tmp != "0" {
                min = min.min(tmp);
            }
            let tmp = num.clone();
            let tmp = tmp.replace(i.to_string().as_str(), "9");
            max = max.max(tmp);
        }
        max.parse::<i32>().unwrap() - min.parse::<i32>().unwrap()
    }
}
impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut c = current.split(":").collect::<Vec<_>>();
        let mut cor = correct.split(":").collect::<Vec<_>>();
        let mut c_hour = c[0].parse::<i32>().unwrap();
        let mut c_min = c[1].parse::<i32>().unwrap();
        let mut cor_hour = cor[0].parse::<i32>().unwrap();
        let mut cor_min = cor[1].parse::<i32>().unwrap();
        let mut ans = 0;
        if cor_min < c_min {
            cor_min += 60;
            cor_hour -= 1;
        }
        ans += (cor_min - c_min) / 5;
        ans += (cor_min - c_min) % 5;
        ans += (cor_hour - c_hour) * 12;
        ans
    }
}
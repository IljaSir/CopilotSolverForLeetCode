impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut year = date[0..4].parse::<i32>().unwrap();
        let mut month = date[5..7].parse::<i32>().unwrap();
        let mut day = date[8..].parse::<i32>().unwrap();
        let mut result = 0;
        let mut days = vec![31,28,31,30,31,30,31,31,30,31,30,31];
        if (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 { days[1] = 29; }
        for i in 0..month-1 { result += days[i as usize]; }
        result += day;
        result
    }
}
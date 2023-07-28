impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut date = date.split('-');
        let year = date.next().unwrap().parse::<i32>().unwrap();
        let month = date.next().unwrap().parse::<i32>().unwrap();
        let day = date.next().unwrap().parse::<i32>().unwrap();
        let mut days = day;
        for i in 1..month {
            days += match i {
                2 => {
                    if year % 400 == 0 || (year % 100 != 0 && year % 4 == 0) { 29 } else { 28 }
                },
                4 | 6 | 9 | 11 => { 30 },
                _ => { 31 }
            }
        }
        days
    }
}
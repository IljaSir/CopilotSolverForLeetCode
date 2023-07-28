impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut day = 0;
        let mut month = 0;
        let mut year = 0;
        
        let mut date = date.split_ascii_whitespace();
        let day_str = date.next().unwrap();
        let month_str = date.next().unwrap();
        let year_str = date.next().unwrap();
        
        if let Ok(d) = day_str[..day_str.len()-2].parse() {
            day = d;
        }
        
        match month_str {
            "Jan" => month = 1,
            "Feb" => month = 2,
            "Mar" => month = 3,
            "Apr" => month = 4,
            "May" => month = 5,
            "Jun" => month = 6,
            "Jul" => month = 7,
            "Aug" => month = 8,
            "Sep" => month = 9,
            "Oct" => month = 10,
            "Nov" => month = 11,
            "Dec" => month = 12,
            _ => (),
        }
        
        if let Ok(y) = year_str.parse() {
            year = y;
        }
        
        format!("{:04}-{:02}-{:02}", year, month, day)
    }
}
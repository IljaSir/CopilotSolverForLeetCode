impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut parts = date.split(" ");
        let day = parts.next().unwrap();
        let month = parts.next().unwrap();
        let year = parts.next().unwrap();
        let mut month = match month {
            "Jan" => "01",
            "Feb" => "02",
            "Mar" => "03",
            "Apr" => "04",
            "May" => "05",
            "Jun" => "06",
            "Jul" => "07",
            "Aug" => "08",
            "Sep" => "09",
            "Oct" => "10",
            "Nov" => "11",
            "Dec" => "12",
            _ => "00",
        };
        let mut day = day.to_string();
        day.pop();
        if day.len() == 1 {
            day = format!("0{}", day);
        }
        format!("{}-{}-{}", year, month, day)
    }
}
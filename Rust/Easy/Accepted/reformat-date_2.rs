impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut date = date.split_ascii_whitespace().collect::<Vec<&str>>();
        let mut month = match date[1] {
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
            _ => "",
        };
        let mut day = date[0].to_string();
        if day.len() == 4 {
            day = day[0..2].to_string();
        } else {
            day = day[0..1].to_string();
        }
        if day.len() == 1 {
            day = "0".to_string() + &day;
        }
        date[2].to_string() + "-" + &month + "-" + &day
    }
}
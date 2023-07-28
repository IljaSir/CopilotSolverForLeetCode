impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut date = date.split_ascii_whitespace().collect::<Vec<&str>>();
        let day = &date[0][..date[0].len()-2];
        let month = date[1];
        let year = date[2];
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
        let mut day = if day.len() == 1 {
            format!("0{}", day)
        } else {
            day.to_string()
        };
        format!("{}-{}-{}", year, month, day)
    }
}